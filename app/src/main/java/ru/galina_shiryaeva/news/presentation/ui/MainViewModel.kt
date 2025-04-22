package ru.galina_shiryaeva.news.presentation.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.galina_shiryaeva.news.domain.model.russianNews.HeadlinesSource
import ru.galina_shiryaeva.news.domain.repository.Repository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    @ApplicationContext context: Context,
    private val repository: Repository
) : ViewModel() {
    suspend fun getRusNews(): List<HeadlinesSource> {
        repository.getAllRussianNews().also { newsResponse ->
            return newsResponse?.sources ?: emptyList<HeadlinesSource>()
        }
    }

}