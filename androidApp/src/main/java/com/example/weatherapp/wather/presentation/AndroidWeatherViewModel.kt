package com.example.weatherapp.wather.presentation

import androidx.lifecycle.ViewModel
import com.example.weatherapp.weather.presentation.WeatherViewModel

class AndroidWeatherViewModel(
    private val sharedWeatherViewModel: WeatherViewModel
) : ViewModel() {

    val stateFlow = sharedWeatherViewModel.weatherStateFlow

    fun getWeather(lat: Double, lon: Double) {
        sharedWeatherViewModel.getWeather(lat, lon)
    }
}
