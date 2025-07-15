package ru.galina_shiryaeva.news.domain.model.weather

data class Current(
    val interval: Int,
    val temperature_2m: Double,
    val time: String,
    val weather_code: Int
)