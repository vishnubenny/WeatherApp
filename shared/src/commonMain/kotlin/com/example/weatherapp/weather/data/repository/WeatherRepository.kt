package com.example.weatherapp.weather.data.repository

import com.example.weatherapp.weather.domain.model.WeatherViewState

interface WeatherRepository {
    suspend fun getWeather(lat: Double, lon: Double): WeatherViewState
}
