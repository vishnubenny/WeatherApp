package com.example.weatherapp.wather.presentation.di

import com.example.weatherapp.wather.presentation.AndroidWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { AndroidWeatherViewModel(get()) } // uses shared ViewModel
}
