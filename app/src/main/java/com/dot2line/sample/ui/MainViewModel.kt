package com.dot2line.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dot2line.sample.api.UnsplashService
import com.dot2line.sample.base.BaseViewModel
import com.dot2line.sample.ui.feed.model.PhotoUiModel
import com.dot2line.sample.ui.feed.model.asUiModel
import com.google.gson.Gson
import kotlinx.coroutines.*
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber


class MainViewModel : BaseViewModel() {

    val contentType = "application/json".toMediaType()
    val client = OkHttpClient.Builder()
        .addInterceptor(
            Interceptor { chain ->
                var request: Request = chain.request()
                val queryAddedUrl: HttpUrl = request.url.newBuilder()
                    .addQueryParameter(
                        "client_id",
                        "7953b566183c3fd1669c3f8f0cab5069b4039974ae793780ce492bbfc1a82ec0"
                    )
                    .build()
                request = request.newBuilder().url(queryAddedUrl).build()
                chain.proceed(request)
            }
        ).build()
    val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://api.unsplash.com/")
        .addConverterFactory(
            GsonConverterFactory.create(Gson())
        )
        .build()
    val unsplashService = retrofit.create(UnsplashService::class.java)

    private val _sample = MutableLiveData<List<PhotoUiModel>>()
    val sample: LiveData<List<PhotoUiModel>> = _sample

    init {
        (viewModelScope + CoroutineExceptionHandler { _, t ->
            Timber.e(t)
        }).launch {
            getPhotos().body()?.map { it.asUiModel() }.let(_sample::postValue)
        }
    }

    private suspend fun getPhotos() = withContext(Dispatchers.Default) {
        unsplashService.getPhotos()
    }
}