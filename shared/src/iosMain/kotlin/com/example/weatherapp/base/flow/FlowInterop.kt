package com.example.weatherapp.base.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

// iOS interoperability extensions
// Interop for iOS
fun <T> StateFlow<T>.watchIOS(scope: CoroutineScope, block: (T) -> Unit) {
    scope.launch(Dispatchers.Main) {
        this@watchIOS.collectLatest {
            block(it)
        }
    }
}
