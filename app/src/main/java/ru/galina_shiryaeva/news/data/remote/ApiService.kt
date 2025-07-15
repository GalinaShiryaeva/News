package ru.galina_shiryaeva.news.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.galina_shiryaeva.news.data.remote.response.everything_by_plants.NewsByPlantsResponse
import ru.galina_shiryaeva.news.data.remote.response.headlines_sources.RusHeadlinesSourcesResponse
import ru.galina_shiryaeva.news.data.remote.response.weather.WeatherResponse
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsItem

//const val GENERAL = "v2/top-headlines/sources?"
//const val LANG_RU_PARAM = "country=ru"
//
//const val EVERYTHING = "v2/everything"
//const val Q_PARAMETER = "?q=plants"
//const val LANG_EN_PARAM = "&language=en"


const val HEADLINES_SOURCES_URL = "v2/top-headlines/sources?country=ru"
const val EVERYTHING_PLANTS_URL = "v2/everything?q=plants&language=en&pageSize=20"
const val ALL_BY_PLANTS_URL = "v2/everything?q=plants&language=en"

const val API_KEY = "&apiKey=46b53b521c1f439995d72d10464636a3"


const val RUS_NEWS_URL = "${HEADLINES_SOURCES_URL}$API_KEY"
// https://newsapi.org/v2/top-headlines/sources?country=ru&apiKey=46b53b521c1f439995d72d10464636a3
const val NEWS_BY_PLANTS_URL = "${EVERYTHING_PLANTS_URL}$API_KEY"
//https://newsapi.org/v2/everything?q=plants&language=en&pageSize=20&page=5&apiKey=46b53b521c1f439995d72d10464636a3
const val NEWS_BY_PLANTS_PAGING_URL = "${ALL_BY_PLANTS_URL}$API_KEY"
//https://newsapi.org/v2/everything?q=plants&language=en&apiKey=46b53b521c1f439995d72d10464636a3
const val CURRENT_WEATHER_MOSCOW = "https://api.open-meteo.com/v1/forecast?latitude=55.7522&longitude=37.6156&current=temperature_2m,weather_code&timezone=Europe%2FMoscow&forecast_days=1"
// https://api.open-meteo.com/v1/forecast?latitude=55.7522&longitude=37.6156&current=temperature_2m,weather_code&timezone=Europe%2FMoscow&forecast_days=1
//https://open-meteo.com/en/docs?timezone=Europe%2FMoscow&latitude=55.7522&longitude=37.6156&forecast_days=1&current=temperature_2m,weather_code,cloud_cover,snowfall,showers,rain,precipitation&hourly=

interface ApiService {

    @GET(RUS_NEWS_URL)
    suspend fun getHeadlinesSources(): Response<RusHeadlinesSourcesResponse?>

    @GET(NEWS_BY_PLANTS_URL)
    suspend fun getNewsByPlants(
    ): Response<NewsByPlantsResponse?>

    @GET(CURRENT_WEATHER_MOSCOW)
    suspend fun getWeather(): Response<WeatherResponse?>

//    // FIXME
//    @GET(NEWS_BY_PLANTS_PAGING_URL)
//    suspend fun getNews(
//        @Query("page") page: Int,
//        @Query("pageSize") pageSize: Int = 15
//    ): Response<NewsByPlantsResponse?>

    @GET(NEWS_BY_PLANTS_PAGING_URL)
    suspend fun getNews(
//        @Query("q") query: String? = null,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = 16
    ): Response<NewsByPlantsResponse?>
}