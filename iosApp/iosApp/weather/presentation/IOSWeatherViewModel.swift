//
// Created by Vishnu Benny on 13/06/25.
// Copyright (c) 2025 orgName. All rights reserved.
//

import shared
import Combine

class IOSWeatherViewModel: ObservableObject {
    private let weatherViewModel: WeatherViewModel
    
    @Published var state: ResponseState<WeatherViewState> = ResponseStateLoading()
    
    init(weatherViewModel: WeatherViewModel) {
        self.weatherViewModel = weatherViewModel
        
        // Observe the shared flow using the watchIOS function
        FlowInteropKt.watchIOS(
            weatherViewModel.weatherStateFlow,
            scope: weatherViewModel.scope(),
            block: { [weak self] newState in
                if let state = newState as? ResponseState<WeatherViewState> {
                    DispatchQueue.main.async {
                        self?.state = state
                    }
                }
            }
        )
    }
    
    func getWeather(lat: Double, lon: Double) {
        weatherViewModel.getWeather(lat: lat, lon: lon)
    }
}
