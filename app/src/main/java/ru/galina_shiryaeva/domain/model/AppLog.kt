package ru.galina_shiryaeva.domain.model

data class AppLog(
    val id: Long,
    val timestamp: String,
    val log: String
) {
    override fun toString(): String {
        return "--- $timestamp $log"
    }
}