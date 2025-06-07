import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greet()

    var body: some View {
        VStack(alignment: .leading, spacing: 12) {
            Text("Welcome")
                .font(.title)
                .bold()

            Text(greet)
                .foregroundColor(.gray)

            Text("From Kotlin Multiplatform!")
                .italic()
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
