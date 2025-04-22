package ru.galina_shiryaeva.news.domain.repository

import ru.galina_shiryaeva.news.domain.model.russianNews.RusHeadlinesSources

interface Repository {

    suspend fun getAllRussianNews(): RusHeadlinesSources?
}