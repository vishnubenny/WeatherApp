package com.example.weatherapp.base.viewmodel

import kotlinx.coroutines.CoroutineScope

interface CoroutineScoped {
    fun setScope(scope: CoroutineScope)
    fun scope(): CoroutineScope
}
