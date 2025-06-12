package com.example.weatherapp.weather.domain.converter

import com.example.weatherapp.base.ResponseState
import com.example.weatherapp.base.flow.Converter
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.domain.model.WeatherViewState

class WeatherViewStateConverter : Converter<WeatherResponse, ResponseState<WeatherViewState>> {

    override fun apply(input: WeatherResponse): ResponseState<WeatherViewState> =
        getWeatherViewState(input)

    private fun getWeatherViewState(weatherResponse: WeatherResponse):
        ResponseState<WeatherViewState> = ResponseState.Success(convert(weatherResponse))

    private fun convert(response: WeatherResponse): WeatherViewState {
        val weather = response.currentWeather
        val units = response.currentWeatherUnits

        return WeatherViewState(
            temperature = "${weather?.temperature ?: "--"}",
            temperatureUnit = units?.temperature ?: "°C",
            windSpeed = "${weather?.windSpeed ?: "--"}",
            windSpeedUnit = units?.windSpeed ?: "km/h",
            windDirection = "${weather?.windDirection ?: "--"}",
            windDirectionUnit = units?.windDirection ?: "°",
            weatherCode = "${weather?.weatherCode ?: "--"}",
            time = weather?.time ?: "--",
            isDay = weather?.isDay == 1,
            conditionCode = weather?.weatherCode ?: -1,
            location = "${response.latitude ?: 0.0}, ${response.longitude ?: 0.0}"
        )
    }
}
