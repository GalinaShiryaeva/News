package ru.galina_shiryaeva.news.data.remote.response.everything_by_plants

import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsByPlants

data class NewsByPlantsResponse(
    val articles: List<ArticleDto>?,
    val status: String,
    val totalResults: Int
) {
    fun mapToDomain() = NewsByPlants(
        articles = articles?.map { it.mapToDomain() },
        status = status,
        totalResults = totalResults
    )
}