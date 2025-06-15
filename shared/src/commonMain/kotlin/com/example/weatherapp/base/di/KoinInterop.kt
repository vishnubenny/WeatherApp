package com.example.weatherapp.base.di

import com.example.weatherapp.weather.presentation.WeatherViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object KoinInterop : KoinComponent {

    fun getWeatherViewModel(): WeatherViewModel = get()
}
