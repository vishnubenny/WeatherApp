package com.example.weatherapp.weather.data.backend

import com.example.weatherapp.weather.data.model.WeatherResponse

interface WeatherBackend {
    /**
     * Fetches the raw weather API response.
     * Returns the exact structure as defined by the OpenMeteo API.
     */
    suspend fun getWeatherRaw(
        latitude: Double,
        longitude: Double
    ): WeatherResponse
}
