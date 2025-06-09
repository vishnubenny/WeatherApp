package com.example.weatherapp.base.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

fun <T> Flow<T>.startFlow(loader: T): Flow<T> {
    return this.onStart { emit(loader) }
}

fun <T> Flow<T>.onError(converter: Converter<Throwable, T>): Flow<T> {
    return this.catch { emit(converter.apply(it)) }
}

fun <T, R> Flow<T>.mapper(converter: Converter<T, R>): Flow<R> {
    return this.map { converter.apply(it) }
}
