package ru.galina_shiryaeva.news.data.remote.response.headlines_sources

import ru.galina_shiryaeva.news.domain.model.russianNews.HeadlinesSource

data class HeadlinesSourceDto(
    val category: String,
    val country: String,
    val description: String,
    val id: String,
    val language: String,
    val name: String,
    val url: String
) {
    fun mapToDomain() = HeadlinesSource(
        category = category,
        country = country,
        description = description,
        id = id,
        language = language,
        name = name,
        url = url,
    )
}