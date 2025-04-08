package ru.galina_shiryaeva.data.local.db

import androidx.room.Dao
import androidx.room.Query

private const val CHARS_LIMIT_FOR_LOG_STRING = 1000

@Dao
interface AppLogDao {
    @Query("SELECT * FROM appLogs ORDER BY id DESC LIMIT $CHARS_LIMIT_FOR_LOG_STRING")
    suspend fun getAll(): List<AppLogEntity?>

    @Query("INSERT INTO appLogs (timestamp, log) VALUES (:timeStampValue, :logValue)")
    suspend fun insert(timeStampValue: String, logValue: String)

    @Query("INSERT INTO appLogs (timestamp, log) VALUES (:timeStampValue, :logValue)")
    fun insertLogInInterceptor(timeStampValue: String, logValue: String)

    @Query("DELETE FROM appLogs")
    suspend fun clearAppLogsTable()
}