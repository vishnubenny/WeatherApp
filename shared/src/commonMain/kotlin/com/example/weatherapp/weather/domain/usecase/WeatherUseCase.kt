package com.example.weatherapp.weather.domain.usecase

import com.example.weatherapp.base.ResponseState
import com.example.weatherapp.base.api.GenericErrorConverter
import com.example.weatherapp.base.flow.mapper
import com.example.weatherapp.base.flow.onError
import com.example.weatherapp.base.flow.startFlow
import com.example.weatherapp.weather.data.repository.WeatherRepository
import com.example.weatherapp.weather.domain.converter.WeatherViewStateConverter
import com.example.weatherapp.weather.domain.model.WeatherViewState
import kotlinx.coroutines.flow.Flow

class WeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val weatherViewStateConverter: WeatherViewStateConverter
) {

    suspend fun getWeather(lat: Double, lon: Double): Flow<ResponseState<WeatherViewState>> =
        weatherRepository.getWeather(lat, lon)
            .mapper(weatherViewStateConverter)
            .startFlow(ResponseState.Loading)
            .onError(GenericErrorConverter())
}
