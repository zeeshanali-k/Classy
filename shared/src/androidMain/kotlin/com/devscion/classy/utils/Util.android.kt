package com.devscion.classy.utils

import androidx.compose.ui.graphics.ImageBitmap


class AndroidStorableImage(
    val imageBitmap: ImageBitmap
)

actual typealias PlatformStorableImage = AndroidStorableImage
