package com.example.weatherapp.weather.presentation.di

import com.example.weatherapp.weather.data.backend.WeatherBackend
import com.example.weatherapp.weather.data.fetcher.WeatherApiFetcher
import com.example.weatherapp.weather.data.impl.WeatherBackendImpl
import com.example.weatherapp.weather.data.impl.WeatherRepositoryImpl
import com.example.weatherapp.weather.data.repository.WeatherRepository
import com.example.weatherapp.weather.domain.converter.WeatherViewStateConverter
import com.example.weatherapp.weather.domain.usecase.WeatherUseCase
import com.example.weatherapp.weather.presentation.WeatherViewModel
import kotlinx.coroutines.MainScope
import org.koin.dsl.module

val weatherModule = module {

    // Network layer
    single<WeatherBackend> { WeatherBackendImpl(get()) }
    single { WeatherApiFetcher(get()) }

    // Repository (bind implementation to interface)
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    // Weather converter
    single { WeatherViewStateConverter() }

    // Weather use case
    single { WeatherUseCase(get(), get()) } // repository, converter

    // Provide shared ViewModel from commonMain
    single { WeatherViewModel(get(), get()) }

    // Provide coroutine scope
    single { MainScope() }
}
