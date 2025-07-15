package ru.galina_shiryaeva.news.data.remote.response.weather

import ru.galina_shiryaeva.news.domain.model.weather.CurrentUnits

data class CurrentUnitsDto(
    val interval: String,
    val temperature_2m: String,
    val time: String,
    val weather_code: String,
) {
    fun mapToDomain() = CurrentUnits(
        interval = interval,
        temperature_2m = temperature_2m,
        time = time,
        weather_code = weather_code
    )
}