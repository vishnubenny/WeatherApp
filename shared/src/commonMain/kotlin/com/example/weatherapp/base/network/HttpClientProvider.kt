package com.example.weatherapp.base.network

import io.ktor.client.HttpClient

expect fun createHttpClient(): HttpClient
