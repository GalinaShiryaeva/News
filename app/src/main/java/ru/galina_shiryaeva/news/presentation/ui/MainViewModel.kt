package ru.galina_shiryaeva.news.presentation.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.galina_shiryaeva.news.domain.repository.Repository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context,
    val repository: Repository
) : ViewModel() {
    suspend fun getRusNews() {
        repository.getAllRussianNews()
    }

}