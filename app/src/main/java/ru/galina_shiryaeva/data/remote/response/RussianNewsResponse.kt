package ru.galina_shiryaeva.data.remote.response

data class RussianNewsResponse(
    val sources: List<Source>,
    val status: String
)