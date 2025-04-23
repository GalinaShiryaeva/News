package ru.galina_shiryaeva.news.data.remote

import retrofit2.Response
import retrofit2.http.GET
import ru.galina_shiryaeva.news.data.remote.response.everything_by_plants.NewsByPlantsResponse
import ru.galina_shiryaeva.news.data.remote.response.headlines_sources.RusHeadlinesSourcesResponse

//const val GENERAL = "v2/top-headlines/sources?"
//const val LANG_RU_PARAM = "country=ru"
//
//const val EVERYTHING = "v2/everything"
//const val Q_PARAMETER = "?q=plants"
//const val LANG_EN_PARAM = "&language=en"


const val HEADLINES_SOURCES_URL = "v2/top-headlines/sources?country=ru"
const val EVERYTHING_PLANTS_URL = "v2/everything?q=plants&language=en&pageSize=20"

const val API_KEY = "&apiKey=46b53b521c1f439995d72d10464636a3"


const val RUS_NEWS_URL = "${HEADLINES_SOURCES_URL}$API_KEY"
// https://newsapi.org/v2/top-headlines/sources?country=ru&apiKey=46b53b521c1f439995d72d10464636a3
const val NEWS_BY_PLANTS_URL = "${EVERYTHING_PLANTS_URL}$API_KEY"
//https://newsapi.org/v2/everything?q=plants&language=en&pageSize=20&page=5&apiKey=46b53b521c1f439995d72d10464636a3

interface ApiService {

    @GET(RUS_NEWS_URL)
    suspend fun getHeadlinesSources(
    ): Response<RusHeadlinesSourcesResponse?>

    @GET(NEWS_BY_PLANTS_URL)
    suspend fun getNewsByPlants(
    ): Response<NewsByPlantsResponse?>


//    @POST(GENERAL)
//    suspend fun getAllRussianNews(
//        @Query("language") language: String = LANG_PARAM,
//        @Query("apiKey") apiKey: String = API_KEY
//    ): Response<RussianNewsResponse>
/*
    @POST(AUTH_LOGIN)
    suspend fun logIn(
        @Body body: AuthLoginBody
    ): Response<AuthLoginResponse>

    @POST(AUTH_LOGOUT)
    suspend fun logOut(
        @Body body: FingerprintBody
    ): Response<AuthLogoutResponse>

    */
}