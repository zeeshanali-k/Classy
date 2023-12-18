package com.devscion.classy.presentation.image_captioning.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devscion.classy.domain.model.PictureData
import com.devscion.classy.utils.PlatformStorableImage

@Composable
expect fun CameraView(
    modifier: Modifier,
    onCapture: (picture: PictureData.Camera, image: PlatformStorableImage) -> Unit
)
