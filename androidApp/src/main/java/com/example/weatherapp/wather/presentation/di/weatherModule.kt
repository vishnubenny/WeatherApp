package com.example.weatherapp.wather.presentation.di

import com.example.weatherapp.wather.presentation.AndroidWeatherViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appWeatherModule = module {
    viewModel { AndroidWeatherViewModel(get()) } // uses shared ViewModel
}
