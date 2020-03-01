package com.dot2line.sample.base

import android.app.Application
import com.dot2line.sample.di.DaggerAppComponent
import timber.log.Timber


class BaseApplication : Application() {

    val appComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

}