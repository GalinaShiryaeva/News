package ru.galina_shiryaeva.news.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsItem
import ru.galina_shiryaeva.news.domain.model.russianNews.HeadlinesSource
import ru.galina_shiryaeva.news.domain.model.weather.Current
import ru.galina_shiryaeva.news.domain.repository.Repository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    @ApplicationContext context: Context,
    private val repository: Repository
) : ViewModel() {

//    private var _foundNewsFlow: Flow<List<NewsItem>> = flowOf(emptyList())
//    val foundNewsFlow = _foundNewsFlow

//    val newsFlow: Flow<PagingData<NewsItem>> = repository.getNewsStream()
//        .cachedIn(viewModelScope)

    private val _weatherStateFlow = MutableStateFlow<Current?>(null)
    val weatherStateFlow: StateFlow<Current?> = _weatherStateFlow.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getWeather()
                .collect { weather ->
                    _weatherStateFlow.value = weather
                }
        }
    }

    suspend fun getNewsWithPaging(): Flow<PagingData<NewsItem>> =
        repository.getNewsPaging().cachedIn(viewModelScope)

    suspend fun getRusHeadlineSources(): List<HeadlinesSource> {
        repository.getRusHeadlineSources().also { rusHeadlineSources ->
            return rusHeadlineSources?.sources ?: emptyList()
        }
    }

    suspend fun getNewsByPlants(): List<NewsItem> {
        repository.getNewsByPlants().also { news ->
//            _foundNewsFlow = listOf(news?.news ?: emptyList()).asFlow()
            return news?.articles ?: emptyList()
        }
    }

}