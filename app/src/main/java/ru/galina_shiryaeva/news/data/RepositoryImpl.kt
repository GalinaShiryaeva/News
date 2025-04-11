package ru.galina_shiryaeva.news.data

import ru.galina_shiryaeva.news.data.remote.ApiService
import ru.galina_shiryaeva.news.domain.model.russianNews.RussianNews
import ru.galina_shiryaeva.news.domain.repository.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
//    private val context: Context
    private val apiService: ApiService
) : Repository {

    override suspend fun getAllRussianNews(): RussianNews? {
        apiService.getAllRussianNews().also { response ->
            println("::::: response = $response")
            return if (response.isSuccessful) {
                response.body()?.mapToDomain()
            } else {
                null
            }
        }

    }
}