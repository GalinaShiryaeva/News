package ru.galina_shiryaeva.news.data.remote.response.everything_by_plants

import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsItem

data class NewsItemDto(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: NewsSourceDto?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) {
    fun mapToDomain() = NewsItem(
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        source = source?.mapToDomain(),
        title = title,
        url = url,
        urlToImage = urlToImage,
    )
}