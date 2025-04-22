package ru.galina_shiryaeva.news.data

import ru.galina_shiryaeva.news.data.remote.ApiService
import ru.galina_shiryaeva.news.domain.model.russianNews.RusHeadlinesSources
import ru.galina_shiryaeva.news.domain.repository.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {

    override suspend fun getAllRussianNews(): RusHeadlinesSources? {
        apiService.getHeadlinesSources().also { response ->
            println("::::: response = ${response.body()}")
            return if (response.isSuccessful) {
                response.body()?.mapToDomain()
            } else {
                null
            }
        }

    }
}