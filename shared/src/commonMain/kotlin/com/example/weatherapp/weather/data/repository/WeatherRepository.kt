package com.example.weatherapp.weather.data.repository

import com.example.weatherapp.weather.data.model.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeather(lat: Double, lon: Double): Flow<WeatherResponse>
}
