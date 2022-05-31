package ru.netology.timetotravel.utils

import android.app.Application
import ru.netology.timetotravel.BuildConfig
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}