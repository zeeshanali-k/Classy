package com.devscion.classy.presentation.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.devscion.classy.presentation.image_annotation.ImageAnnotationScreen
import com.devscion.classy.presentation.menu.components.MenuItem
import com.devscion.classy.presentation.text_to_image.TextToImageScreen
import com.devscion.classy.ui.STANDARD_SPACING
import com.devscion.classy.utils.Vertical

class MenuScreen : Screen {

    @Composable
    override fun Content() {


        val navigator = LocalNavigator.current

        Column(
            Modifier.padding(
                horizontal = 20.dp,
                vertical = 50.dp
            )
        ) {

            Card(
                Modifier.fillMaxSize(),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.elevatedCardElevation()
            ) {
                Column(
                    Modifier.padding(10.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    MenuItem(
                        title = "Text To Image",
                        icon = "txt2img.png"
                    ) {
                        navigator!!.push(TextToImageScreen())
                    }
                    STANDARD_SPACING.Vertical()
                    MenuItem(
                        title = "Image Captioning",
                        icon = "image_annotation.png"
                    ) {
                        navigator!!.push(ImageAnnotationScreen())
                    }
                }

            }

        }
    }


}
