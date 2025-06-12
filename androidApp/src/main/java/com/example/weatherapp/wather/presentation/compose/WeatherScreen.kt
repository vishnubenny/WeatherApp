package com.example.weatherapp.wather.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.base.ResponseState
import com.example.weatherapp.wather.presentation.AndroidWeatherViewModel
import com.example.weatherapp.weather.domain.model.WeatherViewState
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(
    viewModel: AndroidWeatherViewModel = koinViewModel()
) {
    val state by viewModel.weatherStateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getWeather(lat = 12.97, lon = 77.59) // Bangalore coords
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (state) {
            is ResponseState.Loading -> LoadingView()
            is ResponseState.Success -> WeatherContent((state as ResponseState.Success).data)
            is ResponseState.Error -> ErrorView(
                (state as ResponseState.Error).message ?: "Unknown error"
            )
        }
    }
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: $message", color = MaterialTheme.colorScheme.error)
    }
}

@Composable
fun WeatherContent(viewState: WeatherViewState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Weather Info", style = MaterialTheme.typography.headlineSmall)

        Text("Temperature: ${viewState.temperature}")
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview() {
    val dummyState = ResponseState.Success(
        WeatherViewState(
            temperature = "27.5",
            temperatureUnit = "°C",
            windSpeed = "15.2",
            windSpeedUnit = "km/h",
            windDirection = "180",
            windDirectionUnit = "°",
            weatherCode = "2",
            isDay = true,
            time = "2025-06-12T14:00",
            conditionCode = 0,
            location = ""
        )
    )

    MaterialTheme {
        Surface {
            WeatherContent(dummyState.data)
        }
    }
}
