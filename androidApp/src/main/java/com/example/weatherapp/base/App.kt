package com.example.weatherapp.base

import android.app.Application
import com.example.weatherapp.base.di.appModules
import com.example.weatherapp.base.di.initKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(
            appDeclaration = { androidContext(this@App) },
            platformModules = appModules
        )
    }
}
