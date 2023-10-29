package com.devscion.classy.presentation.image_annotation.image_annotation_results

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.devscion.classy.ui.LARGE_SPACING
import com.devscion.classy.ui.STANDARD_ICON_SIZE
import com.devscion.classy.ui.STANDARD_SPACING
import com.devscion.classy.utils.Vertical
import com.devscion.typistcmp.Typist
import com.devscion.typistcmp.TypistSpeed

class ImageAnnotationResultsScreen(
    private val results: String,
) : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current
        Column(
            Modifier.fillMaxSize()
                .background(Color.White)
                .padding(20.dp)
        ) {
            Box(
                Modifier.fillMaxWidth(),
            ) {

                Icon(
                    Icons.Rounded.ArrowBack,
                    "",
                    modifier = Modifier.clickable {
                        navigator?.pop()
                    }.size(STANDARD_ICON_SIZE)
                        .align(Alignment.TopStart)
                )

                Typist(
                    "Annotation Results",
                    typistSpeed = TypistSpeed.EXTRA_FAST,
                    isInfiniteCursor = false,
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            LARGE_SPACING.Vertical()

            Card(
                Modifier.fillMaxWidth()
                    .weight(1f)
            ) {

                Column(
                    Modifier.fillMaxSize()
                        .padding(10.dp)
                ) {

                    Text(
                        "Results", style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    STANDARD_SPACING.Vertical()

                    Typist(
                        results,
                        typistSpeed = TypistSpeed.EXTRA_FAST,
                        isInfiniteCursor = false,
                        textStyle = TextStyle(
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }

        }
    }
}