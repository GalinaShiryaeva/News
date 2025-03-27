package ru.galina_shiryaeva.data.remote

import retrofit2.http.POST
import retrofit2.http.Query

const val GENERAL = "v2/top-headlines/sources?"
const val LANG_PARAM = "ru"
const val API_KEY = "46b53b521c1f439995d72d10464636a3"

interface ApiService {

    @POST(GENERAL)
    suspend fun activateAddition(
        @Query("language") language: String = LANG_PARAM,
        @Query("apiKey") apiKey: String = API_KEY
    )//: Response<ActivateAdditionResponse>
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