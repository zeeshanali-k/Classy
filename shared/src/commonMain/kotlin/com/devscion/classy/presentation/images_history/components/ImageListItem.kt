package com.devscion.classy.presentation.images_history.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.devscion.classy.ui.MEDIUM_PADDING
import com.devscion.classy.utils.rememberImageBitmap
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi


@OptIn(ExperimentalResourceApi::class, ExperimentalEncodingApi::class)
@Composable
fun ImageListItem(base64Image: String, onImageClicked: () -> Unit) {

    Box(
        Modifier.padding(MEDIUM_PADDING)
    ) {
        Card(
            Modifier.fillMaxWidth()
                .height(150.dp)
                .clickable {
                    onImageClicked()
                },
            elevation = CardDefaults.elevatedCardElevation(),
            shape = RoundedCornerShape(10.dp),
        ) {
            val image = rememberImageBitmap(Base64.decode(base64Image))
            if (image != null)
                Image(
                    image, contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            else Image(painterResource("app_logo.jpg"), null)
        }
    }

}