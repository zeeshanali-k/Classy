package com.devscion.classy.presentation.images_history.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devscion.classy.db.Image
import com.devscion.classy.ui.MEDIUM_PADDING
import com.devscion.classy.ui.SMALL_PADDING
import com.devscion.classy.utils.rememberImageBitmap
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi


@OptIn(ExperimentalEncodingApi::class)
@Composable
fun ImageDetailsDialog(image: Image) {

    Column(
        Modifier.fillMaxWidth()
            .background(Color.White)
    ) {
        Box(
            Modifier.fillMaxWidth()
                .height(300.dp)
        ) {

            Image(
                bitmap = rememberImageBitmap(Base64.decode(image.imageBase64))!!,
                "Generated Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                Modifier.fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            listOf(Color.LightGray, Color.Transparent)
                        )
                    )
                    .padding(SMALL_PADDING),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    image.date, style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }
        Box(
            Modifier.fillMaxWidth()
                .background(Color.LightGray)
                .padding(MEDIUM_PADDING)
        ) {
            Text(
                image.prompt, style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            )
        }
    }

}