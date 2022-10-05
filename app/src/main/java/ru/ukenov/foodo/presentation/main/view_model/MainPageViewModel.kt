package ru.ukenov.foodo.presentation.main.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.ukenov.foodo.data.repositories.MainRepository
import ru.ukenov.foodo.domain.main.GetImagesUseCase
import ru.ukenov.foodo.domain.main.Repository
import ru.ukenov.foodo.domain.models.Images

class MainPageViewModel : ViewModel() {
    private val repository: Repository = MainRepository()
    private val getImagesUseCase = GetImagesUseCase(repository)

    private val _images = MutableLiveData<Images>()
    val images: LiveData<Images>
        get() = _images

    fun getImages() {
        viewModelScope.launch {
            val imagesResponse = getImagesUseCase.invoke()
            _images.postValue(imagesResponse)
        }
    }
}