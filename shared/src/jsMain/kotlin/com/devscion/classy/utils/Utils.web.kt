package com.devscion.classy.utils

import org.jetbrains.skia.Image


class WebStorableImage(
    val rawValue: Image
)

actual typealias PlatformStorableImage = WebStorableImage