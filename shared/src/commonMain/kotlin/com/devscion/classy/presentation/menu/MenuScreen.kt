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
import com.devscion.classy.getPlatform
import com.devscion.classy.presentation.menu.components.MenuItem
import com.devscion.classy.ui.STANDARD_SPACING
import com.devscion.classy.utils.Screen
import com.devscion.classy.utils.Vertical

@Composable
fun MenuScreen(onScreenChanged: (Screen) -> Unit) {

//    val navigator = LocalNavigator.current

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
                    onScreenChanged(Screen.Txt2Img)
                }
                if(getPlatform()!=3) {
                    STANDARD_SPACING.Vertical()
                    MenuItem(
                        title = "Image Captioning",
                        icon = "image_annotation.png"
                    ) {
                        onScreenChanged(Screen.ImageCaptioning)
                    }
                }
            }

        }

    }
}

