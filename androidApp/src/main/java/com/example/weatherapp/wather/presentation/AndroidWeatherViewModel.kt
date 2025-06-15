package com.example.weatherapp.wather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.weather.presentation.WeatherViewModel

class AndroidWeatherViewModel(
    private val sharedWeatherViewModel: WeatherViewModel
) : ViewModel() {

    val weatherStateFlow = sharedWeatherViewModel.weatherStateFlow

    fun getWeather(lat: Double, lon: Double) {
        sharedWeatherViewModel.getWeather(lat, lon, viewModelScope)
    }
}
