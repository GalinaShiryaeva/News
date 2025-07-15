package ru.galina_shiryaeva.news.data.remote.response.weather

import ru.galina_shiryaeva.news.domain.model.weather.WeatherMoscow

data class WeatherResponse(
    val current: CurrentDto,
    val current_units: CurrentUnitsDto,
    val elevation: Double,
    val generationtime_ms: Double,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
) {
    fun mapToDomain() = WeatherMoscow(
        current = current.mapToDomain(),
        current_units = current_units.mapToDomain(),
        elevation = elevation,
        generationtime_ms = generationtime_ms,
        latitude = latitude,
        longitude = longitude,
        timezone = timezone,
        timezone_abbreviation = timezone_abbreviation,
        utc_offset_seconds = utc_offset_seconds,
    )
}