package ru.galina_shiryaeva.news.domain.model.everything_by_plants

data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: ArticleSource?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)