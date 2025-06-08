package com.example.weatherapp.weather.domain.model

data class WeatherViewState(
    val temperature: String,
    val windSpeed: String,
    val windDirection: String,
    val time: String,
    val isDay: Boolean,
    val conditionCode: Int,
    val location: String
)
