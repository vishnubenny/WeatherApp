package com.example.weatherapp.base

sealed class ResponseState<T> {
    class Loading<T> : ResponseState<T>()
    data class Success<T>(val data: T) : ResponseState<T>()
    data class Error<T>(val throwable: Throwable, val message: String? = null) : ResponseState<T>()
}
