package com.devscion.classy

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.devscion.classy.di.AppModule
import com.devscion.classy.presentation.splash.SplashScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.KoinApplication


@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    KoinApplication(application ={
        modules(AppModule.appModule())
    } ) {
        MaterialTheme {
            Navigator(SplashScreen())
        }
    }
}
