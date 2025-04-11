package ru.galina_shiryaeva.news.data.local

import androidx.lifecycle.MutableLiveData

object Constants {

    object Network {
        var isUnknownHostException: MutableLiveData<Boolean> = MutableLiveData(false)
        val RU = "ru"
    }
}