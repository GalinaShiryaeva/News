package ru.galina_shiryaeva.news.data.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Response
import ru.galina_shiryaeva.news.data.local.Constants
import ru.galina_shiryaeva.news.data.local.db.AppLogDao
import ru.galina_shiryaeva.news.presentation.utils.TextUtils
import java.net.UnknownHostException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoggingInterceptor @Inject constructor(
    @ApplicationContext val context: Context,
    private val dao: AppLogDao
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val scope = CoroutineScope(Dispatchers.IO)
        val request = chain.request()
        try {
            val requestBody = request.body
            val connection = chain.connection()
            var requestStartMessage =
                ("--> ${request.method} ${request.url}${if (connection != null) " " + connection.protocol() else ""}")
            requestBody?.let {
                requestStartMessage += " (${requestBody.contentLength()}-byte body)"
            }
            scope.launch {
                dao.insert(
                    getLogTimestamp(),
                    "REQUEST $requestStartMessage, body = ${TextUtils.bodyToString(request)}"
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            return chain.proceed(request).also {
                try {
                    val body = it.peekBody(Long.MAX_VALUE).string().take(1000)
                    val code = it.code
                    val message = it.message
                    val url = it.request.url
                    scope.launch {
                        dao.insert(
                            getLogTimestamp(),
                            "RESPONSE <-- $code $body $message $url"
                        )
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } catch (e: UnknownHostException) {
            scope.launch(Dispatchers.Main) {
                Constants.Network.isUnknownHostException.value = true
                Constants.Network.isUnknownHostException.value = false
            }
            scope.launch {
                dao.insert(
                    getLogTimestamp(),
                    "RESPONSE <-- HTTP FAILED: UnknownHostException"
                )
            }
            throw e
        } catch (e: Exception) {
            scope.launch {
                dao.insert(
                    getLogTimestamp(),
                    "RESPONSE <-- HTTP FAILED: $e"
                )
            }
            throw e
        }
    }
}

private fun getLogTimestamp(): String {
    val pattern = SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS", Locale.US)
    return pattern.format(Date())
}