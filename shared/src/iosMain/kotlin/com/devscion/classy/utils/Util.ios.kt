package com.devscion.classy.utils

import platform.UIKit.UIImage


class IosStorableImage(
    val rawValue: UIImage
)

actual typealias PlatformStorableImage = IosStorableImage