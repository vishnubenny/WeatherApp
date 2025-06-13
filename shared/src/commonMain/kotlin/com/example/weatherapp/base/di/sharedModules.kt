package com.example.weatherapp.base.di

import com.example.weatherapp.weather.presentation.di.weatherModule

val sharedModules = listOf(
    networkModule,
    weatherModule
)
