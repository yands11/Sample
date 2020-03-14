package com.dot2line.sample.base

import android.app.Application
import com.dot2line.data.remote.RetrofitFactory
import com.dot2line.data.remote.UnsplashService
import com.dot2line.sample.di.DaggerAppComponent
import timber.log.Timber


class BaseApplication : Application() {

    val appComponent = DaggerAppComponent.create()

    val baseUrl = "https://api.unsplash.com/"
    val unsplashService =
        RetrofitFactory().createService(
            RetrofitFactory().createRetrofit(baseUrl),
            UnsplashService::class.java
        )

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

}