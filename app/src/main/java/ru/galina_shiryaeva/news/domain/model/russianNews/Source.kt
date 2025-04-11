package ru.galina_shiryaeva.news.domain.model.russianNews

data class Source(
    val category: String,
    val country: String,
    val description: String,
    val id: String,
    val language: String,
    val name: String,
    val url: String
)