package com.devscion.classy.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.Image


@Composable
actual fun rememberImageBitmap(imageBytes: ByteArray): ImageBitmap? {
    return remember(imageBytes) {
        try {
            Bitmap.makeFromImage(
                Image.makeFromEncoded(imageBytes)
            ).asComposeImageBitmap()
        }catch (e: Exception) {
            null
        }
    }
}