package com.devscion.classy.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

private const val TAG = "ImageUtils"

@Composable
actual fun rememberImageBitmap(imageBytes: ByteArray): ImageBitmap? {

    return remember {
        try {
            BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size).asImageBitmap()
        } catch (e: Exception) {
            e logAll TAG
            null
        }
    }
}

actual fun convertToByteArray(image: PlatformStorableImage): ByteArray? {
    return try {
        val bos = ByteArrayOutputStream()
        image.imageBitmap.asAndroidBitmap().compress(
            Bitmap.CompressFormat.JPEG,
            90, bos
        )
        bos.close()
        bos.toByteArray()
    } catch (e: Exception) {
        null
    }
}

@OptIn(ExperimentalEncodingApi::class)
actual fun String.isValidBase64Image(): Boolean {
    return try {
        val imageBytes = Base64.decode(this)
        BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size).asImageBitmap()
        true
    } catch (e: Exception) {
        false
    }
}

actual fun ByteArray.toImageBitmap(): ImageBitmap = toAndroidBitmap().asImageBitmap()

fun ByteArray.toAndroidBitmap(): Bitmap {
    return BitmapFactory.decodeByteArray(this, 0, size)
}
