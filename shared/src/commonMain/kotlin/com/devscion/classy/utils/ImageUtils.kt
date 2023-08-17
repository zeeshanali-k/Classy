package com.devscion.classy.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap


@Composable
expect fun rememberImageBitmap(imageBytes : ByteArray) : ImageBitmap?