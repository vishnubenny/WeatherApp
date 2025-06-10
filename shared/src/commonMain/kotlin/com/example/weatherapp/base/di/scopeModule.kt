package com.example.weatherapp.base.di

import kotlinx.coroutines.MainScope
import org.koin.dsl.module

val scopeModule = module {
    single { MainScope() }
}
