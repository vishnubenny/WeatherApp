package com.example.weatherapp.weather.domain.converter

import com.example.weatherapp.base.ResponseState
import com.example.weatherapp.base.flow.Converter
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.domain.model.WeatherViewState

class WeatherViewStateConverter : Converter<WeatherResponse, ResponseState<WeatherViewState>> {

    override fun apply(input: WeatherResponse): ResponseState<WeatherViewState> {
        TODO("Not yet implemented")
    }
}
