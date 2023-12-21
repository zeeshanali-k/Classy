package com.devscion.classy.presentation.text_to_image

import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devscion.classy.data.datasource.DiffusionImagesDataSourceImpl
import com.devscion.classy.ui.ClassicInputField
import com.devscion.classy.ui.MEDIUM_SPACING
import com.devscion.classy.ui.STANDARD_ICON_SIZE
import com.devscion.classy.ui.STANDARD_SPACING
import com.devscion.classy.utils.Horizontal
import com.devscion.classy.utils.RoundedCardBgBox
import com.devscion.classy.utils.Vertical
import com.devscion.classy.utils.rememberImageBitmap
import com.devscion.typistcmp.Typist
import com.devscion.typistcmp.TypistSpeed
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun TextToImageScreenWeb(
    onPopped: () -> Unit
) {
    val viewModel = remember {
        TextToImageViewModel(
            DiffusionImagesDataSourceImpl(null, HttpClient {
                install(ContentNegotiation) {
                    json()
                }
            })
        )
    }
//        val navigator = LocalNavigator.current
    val (image, isLoading, error) = viewModel.homeStateState.collectAsState().value

    val rotation = animateFloatAsState(
        if (isLoading) 360f else 0f, animationSpec = if (isLoading) infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ) else tween(0, easing = EaseInBounce)
    )

    val prompt = remember {
        mutableStateOf("")
    }

    Column(
        Modifier.fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
            .windowInsetsPadding(WindowInsets.systemBars)
            .windowInsetsPadding(WindowInsets.ime)
    ) {

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                Icons.Rounded.ArrowBack,
                "",
                modifier = Modifier.clickable {
                    onPopped()
                }.size(STANDARD_ICON_SIZE)
            )
            MEDIUM_SPACING.Horizontal()
            RoundedCardBgBox(
                customPadding = 0.dp,
                modifier = Modifier.weight(1f),
            ) {
                ClassicInputField(
                    value = prompt.value, onValueChange = {
                        prompt.value = it
                    },
                    enabled = !isLoading,
                    hint = "Prompt"
                )
            }

            STANDARD_SPACING.Horizontal()
            Image(
                painterResource("round_cameraswitch_24.xml"),
                null,
                modifier = Modifier
                    .size(30.dp)
                    .rotate(rotation.value)
                    .clickable {
                        if (!isLoading && prompt.value.isNotEmpty())
                            viewModel.generateImage(prompt.value)
                    }
            )
        }
        20.dp.Vertical()
        Column(
            Modifier.weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (isLoading) {
                CircularProgressIndicator()
                STANDARD_SPACING.Vertical()
                Typist(
                    "Generating Image...", textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ), typistSpeed = TypistSpeed.FAST
                )
            } else if (image != null) {
                val imageBitmap = rememberImageBitmap(image)
                if (imageBitmap != null) {
                    Image(
                        bitmap = imageBitmap,
                        "Generated Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxWidth(0.5f)
                            .height(300.dp)
                    )
                } else {
                    Text(
                        "Invalid Data Received!",
                        color = Color.Red
                    )
                }
            } else if (error.isNotEmpty()) {
                Text(
                    error,
                    color = Color.Red
                )
            }
        }

    }
}