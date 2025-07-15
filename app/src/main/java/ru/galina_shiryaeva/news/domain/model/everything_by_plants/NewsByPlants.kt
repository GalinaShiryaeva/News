package ru.galina_shiryaeva.news.domain.model.everything_by_plants

data class NewsByPlants(
    val articles: List<NewsItem>?,
    val status: String,
    val totalResults: Int
)