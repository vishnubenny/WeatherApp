package com.example.weatherapp.weather.presentation.di

import com.example.weatherapp.weather.data.backend.WeatherBackend
import com.example.weatherapp.weather.data.fetcher.WeatherApiFetcher
import com.example.weatherapp.weather.data.impl.WeatherBackendImpl
import com.example.weatherapp.weather.data.impl.WeatherRepositoryImpl
import com.example.weatherapp.weather.data.repository.WeatherRepository
import com.example.weatherapp.weather.domain.converter.WeatherViewStateConverter
import com.example.weatherapp.weather.domain.usecase.WeatherUseCase
import com.example.weatherapp.weather.presentation.WeatherViewModel
import org.koin.dsl.module

val weatherModule = module {
    single<WeatherBackend> { WeatherBackendImpl(get()) }
    single { WeatherApiFetcher(get()) }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
    single { WeatherViewStateConverter() }
    single { WeatherUseCase(get(), get()) }
    single { WeatherViewModel(get(), get()) }
}
