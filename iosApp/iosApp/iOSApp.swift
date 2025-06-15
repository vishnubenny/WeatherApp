import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
        KoinIosKt.doInitKoinIos(extraModules: [])
    }
    
    var body: some Scene {
        WindowGroup {
            let weatherViewModel = KoinInterop().getWeatherViewModel()
            let iosViewModel = IOSWeatherViewModel(weatherViewModel: weatherViewModel)
            ContentView(viewModel: iosViewModel)
        }
    }
}
