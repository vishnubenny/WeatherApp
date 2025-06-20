package com.example.weatherapp.base.di

import com.example.weatherapp.base.network.createHttpClient
import kotlinx.coroutines.MainScope
import org.koin.dsl.module

val networkModule = module {
    single { MainScope() }
    single { createHttpClient() }
}
