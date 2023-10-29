package com.devscion.classy.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.readBytes
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.Image
import platform.CoreGraphics.CGBitmapContextCreate
import platform.CoreGraphics.CGBitmapContextGetData
import platform.CoreGraphics.CGColorSpaceCreateWithName
import platform.CoreGraphics.CGContextDrawImage
import platform.CoreGraphics.CGImageAlphaInfo
import platform.CoreGraphics.CGImageGetBytesPerRow
import platform.CoreGraphics.CGImageGetColorSpace
import platform.CoreGraphics.CGImageGetHeight
import platform.CoreGraphics.CGImageGetWidth
import platform.CoreGraphics.CGImageRef
import platform.CoreGraphics.CGRectMake
import platform.CoreGraphics.kCGColorSpaceSRGB
import platform.UIKit.UIImage
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi


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

@OptIn(ExperimentalForeignApi::class)
actual fun convertToByteArray(image: PlatformStorableImage): ByteArray? {
    val cgImage: CGImageRef? = image.rawValue.CGImage
    if (cgImage != null) {
        val width = CGImageGetWidth(cgImage)
        val height = CGImageGetHeight(cgImage)
        val bytesPerRow = CGImageGetBytesPerRow(cgImage)
        val colorSpace =
            CGImageGetColorSpace(cgImage) ?: CGColorSpaceCreateWithName(kCGColorSpaceSRGB)

        val bitmapContext = CGBitmapContextCreate(
            null,
            width,
            height,
            8U,
            bytesPerRow,
            colorSpace,
            CGImageAlphaInfo.kCGImageAlphaPremultipliedLast.value
        )

        CGContextDrawImage(
            bitmapContext,
            CGRectMake(0.0, 0.0, width.toDouble(), height.toDouble()),
            cgImage
        )

        val data = CGBitmapContextGetData(bitmapContext)
        return data?.readBytes((bytesPerRow * height).toInt())
    } else {
        return null
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


actual fun ByteArray.toImageBitmap(): ImageBitmap =
    Image.makeFromEncoded(this).toComposeImageBitmap()