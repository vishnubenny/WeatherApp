package com.example.weatherapp.weather.data.fetcher

import com.example.weatherapp.weather.data.backend.WeatherBackend
import com.example.weatherapp.weather.data.model.WeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherApiFetcher(
    private val backend: WeatherBackend
) {
    fun getWeather(lat: Double, lon: Double): Flow<WeatherResponse> = flow {
        val response = backend.getWeatherRaw(lat, lon)
        emit(response)
    }
}
