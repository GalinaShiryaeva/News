package ru.galina_shiryaeva.news.data

import ru.galina_shiryaeva.news.data.remote.ApiService
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsByPlants
import ru.galina_shiryaeva.news.domain.model.russianNews.RusHeadlinesSources
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
        apiService.getNewsByPlants().also { response ->
            println("::::: response getNewsByPlants = ${response.body()}")
            return if (response.isSuccessful) {
                response.body()?.mapToDomain()
            } else {
                null
            }
        }
    }
}