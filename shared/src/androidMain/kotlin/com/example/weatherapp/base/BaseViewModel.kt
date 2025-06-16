package com.example.weatherapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.base.viewmodel.CoroutineScoped

open class BaseViewModel(coroutineScoped: CoroutineScoped? = null) : ViewModel() {

    init {
        coroutineScoped?.setScope(viewModelScope)
    }
}
