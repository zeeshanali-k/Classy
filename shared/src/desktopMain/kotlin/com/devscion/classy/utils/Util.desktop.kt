package com.devscion.classy.utils

import androidx.compose.ui.graphics.ImageBitmap


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

class NameAndDescription(
    val name: String,
    val description: String,
)

@Suppress("NewApi")
@Composable
fun createNewPhotoNameAndDescription(): NameAndDescription {
    return remember {

        Clock.System.now().toLocalDateTime(TimeZone.UTC)
        val kotlinConfEndTime =
            LocalDateTime(2023, Month.APRIL, 14, hour = 23, minute = 59).toInstant(TimeZone.UTC)

        if (Clock.System.now() < kotlinConfEndTime) {
            NameAndDescription(
                "test",
                "test"
            )
        } else {
            NameAndDescription(
                "test",
                "test"
            )
        }
    }
}

class DesktopStorableImage(
    val imageBitmap: ImageBitmap
)

actual typealias PlatformStorableImage = DesktopStorableImage