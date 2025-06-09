package com.example.weatherapp.weather.data.impl

import com.example.weatherapp.weather.data.fetcher.WeatherApiFetcher
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.data.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class WeatherRepositoryImpl(
    private val weatherApiFetcher: WeatherApiFetcher
) : WeatherRepository {

    override suspend fun getWeather(lat: Double, lon: Double): Flow<WeatherResponse> {
        return weatherApiFetcher.getWeather(lat, lon)
            .flowOn(Dispatchers.Default)
    }
}
