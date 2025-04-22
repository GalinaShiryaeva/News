package ru.galina_shiryaeva.news.data.remote.response.headlines_sources

import com.google.gson.annotations.SerializedName
import ru.galina_shiryaeva.news.domain.model.russianNews.RusHeadlinesSources

data class RusHeadlinesSourcesResponse(

    @SerializedName("sources")
    val sources: List<HeadlinesSourceDto>?,
    @SerializedName("status")
    val status: String
) {
    fun mapToDomain() = RusHeadlinesSources(
        sources = sources?.map { it.mapToDomain() },
        status = status
    )
}