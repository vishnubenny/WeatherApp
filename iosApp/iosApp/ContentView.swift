import SwiftUI
import shared

struct ContentView: View {
    @StateObject var viewModel: IOSWeatherViewModel

    var body: some View {
        VStack {
            switch viewModel.state {
            case is ResponseStateLoading<WeatherViewState>:
                ProgressView("Loading...")

            case let success as ResponseStateSuccess<WeatherViewState>:
                if let weather = success.data {
                    Text("Temperature: \(weather.temperature) \(weather.temperatureUnit)")
                        .font(.title2)
                    Text("Wind Speed: \(weather.windSpeed) \(weather.windSpeedUnit)")
                        .font(.subheadline)
                } else {
                    Text("No weather data available")
                }

            case let error as ResponseStateError<WeatherViewState>:
                Text("Error: \(error.message ?? "Unknown error")")
                    .foregroundColor(.red)

            default:
                Text("Idle")
                    .foregroundColor(.gray)
            }
        }
        .padding()
        .onAppear {
            viewModel.getWeather(lat: 37.7749, lon: -122.4194)
        }
    }
}
