package ru.galina_shiryaeva.news.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.paging.map
import androidx.recyclerview.widget.SimpleItemAnimator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.galina_shiryaeva.news.R
import ru.galina_shiryaeva.news.databinding.ActivityMainBinding
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsItem

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var _news: MutableStateFlow<List<NewsItem>> = MutableStateFlow(emptyList())
    val news: StateFlow<List<NewsItem>> get() = _news

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.title.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.getNewsWithPaging().collect { pagingData ->
                    pagingData.map { println("22222 ${it.title}") }
                    withContext(Dispatchers.Main) {
                        initNewsAdapter(pagingData)
                    }
                }
            }
        }

        lifecycleScope.launch {
            viewModel.weatherStateFlow.collectLatest { weather ->
                val temprature = weather?.temperature_2m ?: -100.0
                val weatherCode = weather?.weather_code
                binding.weatherValue.text = String.format("%s°c", temprature)

                when (weatherCode) {
                    0, 1, 2, 3 -> binding.weatherIcon.setImageResource(R.drawable.ic_sun)
                    45, 48 -> binding.weatherIcon.setImageResource(R.drawable.ic_cloud_sun)
                    51, 53, 55, 56, 57 -> binding.weatherIcon.setImageResource(R.drawable.ic_cloud)
                    61, 63, 65, 66, 67 -> binding.weatherIcon.setImageResource(R.drawable.ic_cloud_raining)
                    71, 73, 75, 77, 85, 86 -> binding.weatherIcon.setImageResource(R.drawable.ic_cloud_snowing)
                    80, 81, 82 -> binding.weatherIcon.setImageResource(R.drawable.ic_cloud_heavy_raining)
                    95, 96, 99 -> binding.weatherIcon.setImageResource(R.drawable.ic_cloud_lightning)
                }
            }

//                news.collectLatest { list ->
//                    println(":::::list size = ${list.size}")
//                    initFoundNewsListAdapter(list)
//                }

//                viewModel.getNewsWithPaging().collectLatest { pagingData ->
////                    println(":::::list size1 = ${pagingData.map { i -> println("$i") }}")
//                    println(":::::print list paging")
//                    pagingData.map { i -> println("$i") }
//                    initNewsAdapter(pagingData)
//            }
        }
    }


    private fun initFoundNewsListAdapter(list: List<NewsItem>): FoundNewsAdapter {
        val adapter = FoundNewsAdapter(
            object : NewsItemEventListener1 {
                override fun onMore(newsItem: NewsItem) {
                    // TODO("Nothing here yet")
                }
            }
        )
        binding.newsList.adapter = adapter
        (binding.newsList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        adapter.submitList(list)
        return adapter
    }

    private suspend fun initNewsAdapter(pagingData: PagingData<NewsItem>): NewsAdapter {
        val adapter = NewsAdapter(
            object : NewsItemEventListener {
                override fun onMore(newsItem: NewsItem) {
                    // TODO("Nothing here yet")
                }
            }
        )
        binding.newsList.adapter = adapter
        (binding.newsList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        adapter.submitData(pagingData)
        return adapter
    }
}

/*
Code	Description
0	                солнце
1, 2, 3	            солнце
45, 48	            облачно
51, 53, 55      	тучи
56, 57	            тучи
61, 63, 65          дождь
66, 67          	дождь
71, 73, 75	        снег
77	                снег
80, 81, 82	        ливень
85, 86	            снег
95 *	            гроза
96, 99 *	        гроза

*/