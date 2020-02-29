package com.dot2line.sample.base

import android.app.Application
import timber.log.Timber


class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}