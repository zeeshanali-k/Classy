package com.devscion.classy.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.devscion.classy.presentation.text_to_image.TextToImageScreen
import com.devscion.classy.ui.STANDARD_SPACING
import com.devscion.classy.utils.Vertical

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            Modifier.fillMaxSize()
                .background(Color.White)
                .padding(20.dp)
                .windowInsetsPadding(WindowInsets.systemBars)
                .windowInsetsPadding(WindowInsets.ime)
        ) {
            Button(onClick = {
                navigator?.push(TextToImageScreen())
            }){
                Text("Text to image")
            }
            STANDARD_SPACING.Vertical()
            Button(onClick = {
                navigator?.push(TextToImageScreen())
            }){
                Text("Image to text")
            }
        }
    }
}