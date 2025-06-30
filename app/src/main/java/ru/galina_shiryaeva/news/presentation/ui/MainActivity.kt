package ru.galina_shiryaeva.news.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.SimpleItemAnimator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.galina_shiryaeva.news.databinding.ActivityMainBinding
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.Article

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var _articles: MutableStateFlow<List<Article>> = MutableStateFlow(emptyList())
    val articles: StateFlow<List<Article>> get() = _articles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                _articles.value = viewModel.getNewsByPlants()
//                viewModel.getNewsByPlants()
//                viewModel.foundNewsFlow.collectLatest { list -> }
            }
        }

        lifecycleScope.launch(Dispatchers.Main) {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                articles.collectLatest { list ->
                    println(":::::list size 1= ${list.size}")
                    initFoundNewsListAdapter(list)

                }
            }
        }

    }

    private fun initFoundNewsListAdapter(list: List<Article>): FoundNewsAdapter {
        val adapter = FoundNewsAdapter(
            object : ArticleEventListener {
                override fun onMore(article: Article) {
                    // TODO("Nothing here yet")
                }
            }
        )
        binding.newsList.adapter = adapter
        (binding.newsList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        adapter.submitList(list)
        return adapter
    }
}