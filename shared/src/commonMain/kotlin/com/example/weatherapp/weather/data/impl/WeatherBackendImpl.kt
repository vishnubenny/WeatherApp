package com.example.weatherapp.weather.data.impl

import com.example.weatherapp.weather.data.backend.WeatherBackend
import com.example.weatherapp.weather.data.model.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class WeatherBackendImpl(
    private val client: HttpClient
) : WeatherBackend {

    override suspend fun getWeatherRaw(
        latitude: Double,
        longitude: Double
    ): WeatherResponse {
        val url =
            "https://api.open-meteo.com/v1/forecast?latitude=$latitude&longitude=$longitude&current_weather=true"
        return client.get(url).body()
    }
}
