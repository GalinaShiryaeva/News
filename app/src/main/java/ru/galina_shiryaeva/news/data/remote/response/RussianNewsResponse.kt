package ru.galina_shiryaeva.news.data.remote.response

import com.google.gson.annotations.SerializedName
import ru.galina_shiryaeva.news.domain.model.russianNews.RussianNews

data class RussianNewsResponse(

    @SerializedName("sources")
    val sources: List<SourceDto>?,
    @SerializedName("status")
    val status: String
) {
    fun mapToDomain() = RussianNews(
        sources = sources?.map { it.mapToDomain() },
        status = status
    )
}