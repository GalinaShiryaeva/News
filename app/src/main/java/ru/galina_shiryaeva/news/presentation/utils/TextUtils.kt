package ru.galina_shiryaeva.news.presentation.utils

import android.annotation.SuppressLint
import okhttp3.Request
import okio.Buffer
import java.io.IOException

@SuppressLint("LogNotTimber")
object TextUtils {




    fun validateEmail(input: String): String {
        val pattern = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
        return pattern.find(input)?.value ?: ""
    }

//    fun isItTimeToUpdateToken(accessToken: String?): Boolean {
//        val expTimeSeconds = getExpTimeInSeconds(accessToken)
//        val currentTimeSeconds = System.currentTimeMillis() / 1000L
//        val remainingTimeSeconds = expTimeSeconds - currentTimeSeconds
//        return remainingTimeSeconds <= Constants.Auth.TIME_GAP_BEFORE_ACCESS_TOKEN_EXPIRE
//    }

//    fun isAccessTokenValid(accessToken: String?): Boolean {
//        if (accessToken.isNullOrEmpty()) return true
//        val expTimeSeconds = getExpTimeInSeconds(accessToken)
//        val currentTimeSeconds = System.currentTimeMillis() / 1000L
//        val difference = expTimeSeconds - currentTimeSeconds
//        val whole = difference / 60
//        val fractional = abs(difference - (whole * 60))
//        if (expTimeSeconds != 0L) {
//            Log.i(
//                "AUTH",
//                "Токен ' .${getTokenSnippet(accessToken)} ' годен ещё = $whole:$fractional минут : TextUtils/isAccessTokenExpired()"
//            )
//        } else {
//            Log.i(
//                "AUTH",
//                "Токен ' .${getTokenSnippet(accessToken)} ' годен ещё = ранее не был установлен : TextUtils/isAccessTokenExpired()"
//            )
//        }
//        return expTimeSeconds > currentTimeSeconds // true if the token is still valid
//    }

//    fun remainingTimeToken(accessToken: String?): String {
//        if (accessToken.isNullOrEmpty())
//            return "Токен ' .${getTokenSnippet(accessToken)} ' годен ещё = null "
//        val expTimeSeconds = getExpTimeInSeconds(accessToken)
//        val currentTimeSeconds = System.currentTimeMillis() / 1000L
//        val difference = expTimeSeconds - currentTimeSeconds
//        val whole = difference / 60
//        val fractional = abs(difference - (whole * 60))
//        return if (expTimeSeconds != 0L) {
//            "Токен ' .${getTokenSnippet(accessToken)} ' годен ещё = $whole:$fractional"
//        } else {
//            "Токен ' .${getTokenSnippet(accessToken)} ' годен ещё = ранее не был установлен"
//        }
//    }

//    fun getExpTimeInSeconds(accessToken: String?): Long {
//        if (accessToken.isNullOrEmpty()) return 0L
//        val decoded = String(Base64().decode(accessToken.toByteArray()))
//        val pattern: Pattern = Pattern.compile(TIMESTAMP_REGEX)
//        val matcher: Matcher = pattern.matcher(decoded)
//        if (matcher.find()) {
//            return matcher.group(1)?.toLong() ?: 0L
//        }
//        return 0L
//    }

    fun bodyToString(request: Request): String? {
        return try {
            val copy: Request = request.newBuilder().build()
            val buffer = Buffer()
            copy.body?.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            "bodyToString() did not work"
        }
    }
}