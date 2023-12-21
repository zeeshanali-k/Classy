package com.devscion.classy

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.devscion.classy.di.AppModules
import com.devscion.classy.presentation.image_captioning.ImageCaptioningScreen
import com.devscion.classy.presentation.image_captioning.image_annotation_results.ImageCaptioningResultsScreen
import com.devscion.classy.presentation.menu.MenuScreen
import com.devscion.classy.presentation.splash.SplashScreen
import com.devscion.classy.presentation.text_to_image.TextToImageScreen
import com.devscion.classy.presentation.text_to_image.TextToImageScreenWeb
import com.devscion.classy.utils.Screen
import org.koin.compose.KoinApplication


@Composable
fun App() {
    if (getPlatform() == 3) {
        AppNavigation()
    } else {
        KoinApplication(application = {
            modules(AppModules.core())
        }) {
            AppNavigation()
        }
    }
}

expect fun getPlatform(): Int

@Composable
private fun AppNavigation() {
    MaterialTheme {
        var currentScreen by remember {
            mutableStateOf<Screen>(Screen.Splash)
        }
        var text by remember {
            mutableStateOf("")
        }
        when (currentScreen) {
            is Screen.Splash -> SplashScreen {
                currentScreen = it
            }

            is Screen.Menu -> MenuScreen {
                currentScreen = it
            }

            is Screen.ImageCaptioning -> ImageCaptioningScreen({ screen, t ->
                currentScreen = screen
                text = t
            }, onPopped = {
                currentScreen = Screen.Menu
            })

            is Screen.ImageCaptioningResult -> ImageCaptioningResultsScreen(text,
                onPopped = {
                    currentScreen = Screen.ImageCaptioning
                })

            is Screen.Txt2Img -> if (getPlatform() == 3) TextToImageScreenWeb {
                currentScreen = Screen.Menu
            } else TextToImageScreen {

                currentScreen = Screen.Menu
            }

        }
    }
}
