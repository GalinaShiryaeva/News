package ru.galina_shiryaeva.news.data

import android.widget.Toast
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import ru.galina_shiryaeva.news.data.remote.ApiService
import ru.galina_shiryaeva.news.data.remote.response.weather.CurrentDto
import ru.galina_shiryaeva.news.data.util.NewsPagingSource
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsByPlants
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsItem
import ru.galina_shiryaeva.news.domain.model.russianNews.RusHeadlinesSources
import ru.galina_shiryaeva.news.domain.model.weather.Current
import ru.galina_shiryaeva.news.domain.repository.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {

    override suspend fun getRusHeadlineSources(): RusHeadlinesSources? {
        apiService.getHeadlinesSources().also { response ->
            println("::::: response getHeadlinesSources = ${response.body()}")
            return if (response.isSuccessful) {
                response.body()?.mapToDomain()
            } else {
                null
            }
        }

    }

    override suspend fun getNewsByPlants(): NewsByPlants? {
//        apiService.getNewsByPlants().also { response ->
        apiService.getNews(1, 12).also { response ->
            println("::::: response.size getNewsByPlants = ${response.body()?.articles?.size}")
            return if (response.isSuccessful) {
                response.body()?.mapToDomain()
            } else {
                null
            }
        }
    }

    // FIXME
    override fun getNewsPaging(): Flow<PagingData<NewsItem>> {
        return Pager(config = PagingConfig(
            pageSize = 17,
            enablePlaceholders = false,
            initialLoadSize = 31,
            prefetchDistance = 5,
            maxSize = 40
        ), pagingSourceFactory = { NewsPagingSource(apiService) }).flow
    }

    override suspend fun getWeather(): Flow<Current?> {
        val temperature = try {
            val response = apiService.getWeather().body()
            response?.current?.mapToDomain()
        } catch (e: Exception) {
            e.printStackTrace()
            Current(
                interval = 0,
                time = "",
                temperature_2m = -100.0,
                weather_code = 0
            )
        }
        return flow { emit(temperature) }
    }
}