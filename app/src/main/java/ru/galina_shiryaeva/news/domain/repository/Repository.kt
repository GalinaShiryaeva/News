package ru.galina_shiryaeva.news.domain.repository

import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsByPlants
import ru.galina_shiryaeva.news.domain.model.russianNews.RusHeadlinesSources

interface Repository {

    suspend fun getRusHeadlineSources(): RusHeadlinesSources?
    suspend fun getNewsByPlants(): NewsByPlants?
}
