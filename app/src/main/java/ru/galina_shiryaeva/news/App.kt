package ru.galina_shiryaeva.news

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        println("````````````````` App - onCreate `````````````````")
    }
}