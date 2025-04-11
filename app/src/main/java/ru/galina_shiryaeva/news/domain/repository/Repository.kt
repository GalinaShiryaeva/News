package ru.galina_shiryaeva.news.domain.repository

import ru.galina_shiryaeva.news.domain.model.russianNews.RussianNews

interface Repository {

    suspend fun getAllRussianNews(): RussianNews?
}