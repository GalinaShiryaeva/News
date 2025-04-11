package ru.galina_shiryaeva.news.data.remote

import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query
import ru.galina_shiryaeva.news.data.remote.response.RussianNewsResponse

const val GENERAL = "v2/top-headlines/sources?"
const val LANG_PARAM = "ru"
const val API_KEY = "46b53b521c1f439995d72d10464636a3"

const val RUS_NEWS_URL = "${GENERAL}country=${LANG_PARAM}&apiKey=$API_KEY"
// https://newsapi.org/v2/top-headlines/sources?country=ru&apiKey=46b53b521c1f439995d72d10464636a3

interface ApiService {

    @POST(RUS_NEWS_URL)
    suspend fun getAllRussianNews(
//        @Query("country") country: String = LANG_PARAM,
//        @Query("apiKey") apiKey: String = API_KEY
    ): Response<RussianNewsResponse?>


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