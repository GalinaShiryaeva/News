package ru.galina_shiryaeva.news.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsByPlants
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsItem
import ru.galina_shiryaeva.news.domain.model.russianNews.RusHeadlinesSources
import ru.galina_shiryaeva.news.domain.model.weather.Current

interface Repository {

    suspend fun getRusHeadlineSources(): RusHeadlinesSources?
    suspend fun getNewsByPlants(): NewsByPlants?
    fun getNewsPaging(): Flow<PagingData<NewsItem>>
    suspend fun getWeather(): Flow<Current?>
}
