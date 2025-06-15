package com.example.weatherapp.base.di

import org.koin.core.KoinApplication
import org.koin.core.module.Module

fun initKoinIos(extraModules: List<Module> = emptyList()): KoinApplication =
    initKoin(platformModules = extraModules)
