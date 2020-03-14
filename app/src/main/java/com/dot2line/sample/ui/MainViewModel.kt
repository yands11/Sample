package com.dot2line.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dot2line.domain.Error
import com.dot2line.domain.photo.GetPhotosUseCase
import com.dot2line.domain.Success
import com.dot2line.sample.base.BaseViewModel
import com.dot2line.sample.ui.feed.model.PhotoUiModel
import com.dot2line.sample.ui.feed.model.asUiModel
import kotlinx.coroutines.*
import timber.log.Timber


class MainViewModel(private val getPhotosUseCase: GetPhotosUseCase) : BaseViewModel() {

    private val _sample = MutableLiveData<List<PhotoUiModel>>()
    val sample: LiveData<List<PhotoUiModel>> = _sample

    init {
        (viewModelScope + CoroutineExceptionHandler { _, t ->
            Timber.e(t)
        }).launch {
            getPhotos().let { result ->
                when (result) {
                    is Success -> result.data.map { it.asUiModel() }.let(_sample::postValue)
                    is Error -> Timber.e("Error: ${result.code}")
                }
            }
        }
    }

    private suspend fun getPhotos() = withContext(Dispatchers.Default) {
        getPhotosUseCase.execute(
            GetPhotosUseCase.Param(1, 20)
        )
    }
}