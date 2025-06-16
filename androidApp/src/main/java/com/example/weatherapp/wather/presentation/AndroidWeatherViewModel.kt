package com.example.weatherapp.wather.presentation

import com.example.weatherapp.base.BaseViewModel
import com.example.weatherapp.weather.presentation.WeatherViewModel

class AndroidWeatherViewModel(
    private val sharedWeatherViewModel: WeatherViewModel
) : BaseViewModel(sharedWeatherViewModel) {

    val weatherStateFlow = sharedWeatherViewModel.weatherStateFlow

    fun getWeather(lat: Double, lon: Double) {
        sharedWeatherViewModel.getWeather(lat, lon)
    }
}
