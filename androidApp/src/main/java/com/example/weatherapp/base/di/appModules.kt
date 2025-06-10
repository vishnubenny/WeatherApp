package com.example.weatherapp.base.di

import com.example.weatherapp.wather.presentation.di.androidModule
import com.example.weatherapp.weather.presentation.di.weatherModule

val appModules = listOf(
    networkModule,
    weatherModule,
    androidModule
)
