package com.dot2line.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dot2line.domain.photo.GetPhotosUseCase

class MainViewModelFactory(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        (MainViewModel(getPhotosUseCase) as T)
}
