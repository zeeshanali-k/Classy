package com.devscion.classy.presentation.image_annotation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.devscion.classy.presentation.image_annotation.components.CameraView
import com.devscion.classy.presentation.image_annotation.image_annotation_results.ImageAnnotationResultsScreen
import com.devscion.classy.ui.SMALL_SPACING
import com.devscion.classy.ui.STANDARD_ICON_SIZE
import com.devscion.classy.utils.Vertical
import com.devscion.typistcmp.Typist
import com.devscion.typistcmp.TypistSpeed
import com.mohamedrejeb.calf.ui.progress.AdaptiveCircularProgressIndicator
import org.koin.compose.koinInject

class ImageAnnotationScreen : Screen {

    @Composable
    override fun Content() {

        val viewModel = koinInject<ImageToTextViewModel>()
        val state = viewModel.imageToTextState.collectAsState().value
        val navigator = LocalNavigator.current
        if (state.text.isNullOrEmpty().not()) {
            navigator!!.push(ImageAnnotationResultsScreen(state.text!!))
        }
        Box(
            Modifier.fillMaxSize()
                .background(Color.White)
                .padding(10.dp)
                .windowInsetsPadding(WindowInsets.systemBars)
                .windowInsetsPadding(WindowInsets.ime),
            contentAlignment = Alignment.Center
        ) {

            if (state.isLoading) {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AdaptiveCircularProgressIndicator()
                    SMALL_SPACING.Vertical()

                    Typist(
                        "Annotating Image...",
                        typistSpeed = TypistSpeed.FAST,
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        ),
                    )
                }
            } else {
                CameraView(Modifier.fillMaxSize()) { _, image ->
                    viewModel.generateText(image)
                }
            }

            Icon(
                Icons.Rounded.ArrowBack,
                "",
                tint = Color.White,
                modifier = Modifier
                    .size(STANDARD_ICON_SIZE)
                    .align(Alignment.TopStart)
                    .clickable {
                        navigator?.pop()
                    }
            )
        }

    }
}