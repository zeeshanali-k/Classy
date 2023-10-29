package com.devscion.classy

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.devscion.classy.di.AppModules
import com.devscion.classy.presentation.splash.SplashScreen
import org.koin.compose.KoinApplication


@Composable
fun App() {
    KoinApplication(application = {
        modules(AppModules.core())
    }) {
        MaterialTheme {
            Navigator(SplashScreen())
        }
    }
}
