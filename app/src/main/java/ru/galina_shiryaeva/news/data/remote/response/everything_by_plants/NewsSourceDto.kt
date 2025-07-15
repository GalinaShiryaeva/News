package ru.galina_shiryaeva.news.data.remote.response.everything_by_plants

import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsSource

data class NewsSourceDto(
    val id: String?,
    val name: String?
) {
    fun mapToDomain() = NewsSource(
        id = id,
        name = name
    )
}