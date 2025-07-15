package ru.galina_shiryaeva.news.domain.model.weather

data class CurrentUnits(
    val interval: String,
    val temperature_2m: String,
    val time: String,
    val weather_code: String
)