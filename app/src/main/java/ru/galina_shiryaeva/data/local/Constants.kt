package ru.galina_shiryaeva.data.local

import androidx.lifecycle.MutableLiveData

object Constants {

    object Network {
        var isUnknownHostException: MutableLiveData<Boolean> = MutableLiveData(false)
    }
}