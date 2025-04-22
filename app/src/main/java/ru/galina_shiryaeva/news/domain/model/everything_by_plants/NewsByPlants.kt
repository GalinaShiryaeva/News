package ru.galina_shiryaeva.news.domain.model.everything_by_plants

data class NewsByPlants(
    val articles: List<Article>?,
    val status: String,
    val totalResults: Int
)