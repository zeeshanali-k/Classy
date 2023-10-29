package com.devscion.classy.utils


import androidx.compose.ui.graphics.ImageBitmap
class DesktopStorableImage(
    val imageBitmap: ImageBitmap
)

actual typealias PlatformStorableImage = DesktopStorableImage