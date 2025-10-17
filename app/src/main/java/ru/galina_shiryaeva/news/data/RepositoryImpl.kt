package ru.galina_shiryaeva.news.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.galina_shiryaeva.news.data.remote.ApiService
import ru.galina_shiryaeva.news.data.util.NewsPagingSource
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsByPlants
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsItem
import ru.galina_shiryaeva.news.domain.model.russianNews.RusHeadlinesSources
import ru.galina_shiryaeva.news.domain.model.weather.Current
import ru.galina_shiryaeva.news.domain.repository.Repository
import java.net.SocketTimeoutException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {

    override suspend fun getRusHeadlineSources(): RusHeadlinesSources? {
        apiService.getHeadlinesSources().also { response ->
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
            pageSize = 10,
            enablePlaceholders = false,
            initialLoadSize = 10,
            prefetchDistance = 5
        ), pagingSourceFactory = { NewsPagingSource(apiService) }).flow
    }

    override suspend fun getWeather(): Flow<Current?> = flow {
        var retryCount = 0
        val maxRetries = 3
        while (retryCount <= maxRetries) {
            try {
                val response = apiService.getWeather().body()
                val current = response?.current?.mapToDomain()
                emit(current)
                Log.i("WEATHER","RepositoryImpl - getWeather(): ok")
                return@flow
            } catch (e: SocketTimeoutException) {
                if (retryCount == maxRetries) {
                    emit(null)
                    return@flow
                }
                retryCount++
                Log.i("WEATHER","RepositoryImpl - getWeather(): SocketTimeoutException retryCount = $retryCount")
            } catch (e: Exception) {
                e.printStackTrace()
                emit(null)
                Log.i("WEATHER","RepositoryImpl - getWeather(): Exception")
                return@flow
            }
        }
        emit(null)
    }
}