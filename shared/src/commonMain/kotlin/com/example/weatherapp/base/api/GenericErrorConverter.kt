package com.example.weatherapp.base.api

import com.example.weatherapp.base.ResponseState
import com.example.weatherapp.base.flow.Converter
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.SerializationException

class GenericErrorConverter<T> : Converter<Throwable, ResponseState<T>> {

    override fun apply(input: Throwable): ResponseState<T> = convertToCause(input)

    private fun convertToCause(cause: Throwable): ResponseState.Error {
        return when (cause) {
            is ClientRequestException,
            is ServerResponseException,
            is RedirectResponseException -> ResponseState.Error(cause)

            is HttpRequestTimeoutException -> ResponseState.Error(cause)

            is SerializationException -> ResponseState.Error(cause)

            is IOException -> ResponseState.Error(cause)

            else -> ResponseState.Error(cause)
        }
    }
}
