package com.devscion.classy.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap


@Composable
expect fun rememberImageBitmap(imageBytes : ByteArray) : ImageBitmap?

expect fun String.isValidBase64Image(): Boolean

expect fun convertToByteArray(image : PlatformStorableImage) : ByteArray?

expect fun ByteArray.toImageBitmap(): ImageBitmap