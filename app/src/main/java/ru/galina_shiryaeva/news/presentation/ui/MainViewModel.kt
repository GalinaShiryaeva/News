package ru.galina_shiryaeva.news.presentation.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.Article
import ru.galina_shiryaeva.news.domain.model.russianNews.HeadlinesSource
import ru.galina_shiryaeva.news.domain.repository.Repository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    @ApplicationContext context: Context,
    private val repository: Repository
) : ViewModel() {

//    private var _foundNewsFlow: Flow<List<Article>> = flowOf(emptyList())
//    val foundNewsFlow = _foundNewsFlow

    suspend fun getRusHeadlineSources(): List<HeadlinesSource> {
        repository.getRusHeadlineSources().also { rusHeadlineSources ->
            return rusHeadlineSources?.sources ?: emptyList()
        }
    }

    suspend fun getNewsByPlants(): List<Article> {
        repository.getNewsByPlants().also { news ->
//            _foundNewsFlow = listOf(news?.articles ?: emptyList()).asFlow()
            return news?.articles ?: emptyList()
        }
    }

}