package com.devscion.classy.utils

import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.Image
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import androidx.compose.ui.graphics.toComposeImageBitmap

val IconPhotoCamera = materialIcon(name = "Filled.PhotoCamera") {
    materialPath {
        moveTo(12.0f, 12.0f)
        moveToRelative(-3.2f, 0.0f)
        arcToRelative(3.2f, 3.2f, 0.0f, true, true, 6.4f, 0.0f)
        arcToRelative(3.2f, 3.2f, 0.0f, true, true, -6.4f, 0.0f)
    }
    materialPath {
        moveTo(9.0f, 2.0f)
        lineTo(7.17f, 4.0f)
        lineTo(4.0f, 4.0f)
        curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f)
        verticalLineToRelative(12.0f)
        curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
        horizontalLineToRelative(16.0f)
        curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
        lineTo(22.0f, 6.0f)
        curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f)
        horizontalLineToRelative(-3.17f)
        lineTo(15.0f, 2.0f)
        lineTo(9.0f, 2.0f)
        close()
        moveTo(12.0f, 17.0f)
        curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f)
        reflectiveCurveToRelative(2.24f, -5.0f, 5.0f, -5.0f)
        reflectiveCurveToRelative(5.0f, 2.24f, 5.0f, 5.0f)
        reflectiveCurveToRelative(-2.24f, 5.0f, -5.0f, 5.0f)
        close()
    }
}

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

actual fun convertToByteArray(image : PlatformStorableImage) : ByteArray? = null

actual fun ByteArray.toImageBitmap(): ImageBitmap =
    Image.makeFromEncoded(this).toComposeImageBitmap()