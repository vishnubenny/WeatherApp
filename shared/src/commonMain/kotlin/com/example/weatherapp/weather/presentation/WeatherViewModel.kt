package com.example.weatherapp.weather.presentation

import com.example.weatherapp.base.ResponseState
import com.example.weatherapp.weather.domain.model.WeatherViewState
import com.example.weatherapp.weather.domain.usecase.WeatherUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherUseCase: WeatherUseCase,
    private val scope: CoroutineScope
) {

    private val weatherState =
        MutableStateFlow<ResponseState<WeatherViewState>>(ResponseState.Loading())
    val weatherStateFlow: StateFlow<ResponseState<WeatherViewState>> = weatherState.asStateFlow()

    fun getWeather(lat: Double, lon: Double) {
        scope.launch {
            weatherUseCase.getWeather(lat, lon).collect {
                weatherState.emit(it)
            }
        }
    }

    fun scope() = scope
}
