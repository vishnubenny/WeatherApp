package com.example.weatherapp.base

sealed class ResponseState<out T> {
    data class Success<T>(val data: T) : ResponseState<T>()
    data class Error(val throwable: Throwable, val message: String? = null) :
        ResponseState<Nothing>()

    data object Loading : ResponseState<Nothing>()
}
