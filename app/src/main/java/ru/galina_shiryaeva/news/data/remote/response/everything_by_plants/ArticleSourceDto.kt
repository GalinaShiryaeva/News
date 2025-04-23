package ru.galina_shiryaeva.news.data.remote.response.everything_by_plants

import ru.galina_shiryaeva.news.domain.model.everything_by_plants.ArticleSource

data class ArticleSourceDto(
    val id: String?,
    val name: String?
) {
    fun mapToDomain() = ArticleSource(
        id = id,
        name = name
    )
}