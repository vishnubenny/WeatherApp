package com.example.weatherapp.base.viewmodel

import kotlinx.coroutines.CoroutineScope

open class SharedViewModel(private var scope: CoroutineScope) : CoroutineScoped {

    override fun setScope(scope: CoroutineScope) {
        this.scope = scope
    }

    /**
     * Method used in iosApp module also
     */
    override fun scope(): CoroutineScope = scope
}
