package com.devscion.classy.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.Image
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.skia.Image

@Composable
actual fun rememberImageBitmap(imageBytes: ByteArray): ImageBitmap? {
    return remember(imageBytes) {
        try {
            Bitmap.makeFromImage(
                Image.makeFromEncoded(imageBytes)
            ).asComposeImageBitmap()
        } catch (e: Exception) {
            null
        }
    }
}

@OptIn(ExperimentalEncodingApi::class)
actual fun String.isValidBase64Image(): Boolean {
    return try {
        val imageBytes = Base64.decode(this)
        Bitmap.makeFromImage(
            Image.makeFromEncoded(imageBytes)
        ).asComposeImageBitmap()
        true
    } catch (e: Exception) {
        false
    }
}


actual fun ByteArray.toImageBitmap(): ImageBitmap =
    Image.makeFromEncoded(this).toComposeImageBitmap()