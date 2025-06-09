package com.example.weatherapp.base.flow

interface Converter<T, R> {

    fun apply(input: T): R
}
