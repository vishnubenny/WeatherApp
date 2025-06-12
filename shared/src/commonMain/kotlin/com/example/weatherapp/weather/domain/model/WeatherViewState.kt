package com.example.weatherapp.weather.domain.model

data class WeatherViewState(
    val temperature: String,
    val temperatureUnit: String,
    val windSpeed: String,
    val windSpeedUnit: String,
    val windDirection: String,
    val windDirectionUnit: String,
    val weatherCode: String,
    val time: String,
    val isDay: Boolean,
    val conditionCode: Int,
    val location: String
)
