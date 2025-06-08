package com.example.weatherapp.weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("current_weather") val currentWeather: CurrentWeather?,
    @SerialName("current_weather_units") val currentWeatherUnits: CurrentWeatherUnits?,
    @SerialName("elevation") val elevation: Double?,
    @SerialName("generationtime_ms") val generationTimeMs: Double?,
    @SerialName("latitude") val latitude: Double?,
    @SerialName("longitude") val longitude: Double?,
    @SerialName("timezone") val timezone: String?,
    @SerialName("timezone_abbreviation") val timezoneAbbreviation: String?,
    @SerialName("utc_offset_seconds") val utcOffsetSeconds: Int?
)
