package com.example.weatherapp.base.di

import com.example.weatherapp.base.network.createHttpClient
import org.koin.dsl.module

val networkModule = module {

    // HttpClient
    single { createHttpClient() }
}
