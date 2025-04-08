package ru.galina_shiryaeva.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.galina_shiryaeva.domain.model.AppLog

@Entity(tableName = "appLogs")
data class AppLogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "timestamp") val timestamp: String,
    @ColumnInfo(name = "log") val log: String
) {
    fun mapFromEntityToDomain() = AppLog(
        id = id,
        timestamp = timestamp,
        log = log
    )
}