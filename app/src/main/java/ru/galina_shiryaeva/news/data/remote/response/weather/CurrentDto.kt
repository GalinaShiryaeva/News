package ru.galina_shiryaeva.news.data.remote.response.weather

import ru.galina_shiryaeva.news.domain.model.weather.Current

data class CurrentDto(
    val interval: Int,
    val temperature_2m: Double,
    val time: String,
    val weather_code: Int
) {
    fun mapToDomain() = Current(
        interval = interval,
        temperature_2m = temperature_2m,
        time = time,
        weather_code = weather_code
    )
}