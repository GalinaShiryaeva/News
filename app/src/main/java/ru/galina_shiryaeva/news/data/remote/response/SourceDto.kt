package ru.galina_shiryaeva.news.data.remote.response

import ru.galina_shiryaeva.news.domain.model.russianNews.Source

data class SourceDto(
    val category: String,
    val country: String,
    val description: String,
    val id: String,
    val language: String,
    val name: String,
    val url: String
) {
    fun mapToDomain() = Source(
        category = category,
        country = country,
        description = description,
        id = id,
        language = language,
        name = name,
        url = url,
    )
}