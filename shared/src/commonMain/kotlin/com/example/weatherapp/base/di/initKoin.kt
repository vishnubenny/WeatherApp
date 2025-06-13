package com.example.weatherapp.base.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

// shared/commonMain/di/Koin.kt
fun initKoin(
    appDeclaration: KoinAppDeclaration = {},
    platformModules: List<Module> = emptyList()
): KoinApplication = startKoin {
    appDeclaration()
    modules(
        *sharedModules.toTypedArray(),
        *platformModules.toTypedArray()
    )
}
