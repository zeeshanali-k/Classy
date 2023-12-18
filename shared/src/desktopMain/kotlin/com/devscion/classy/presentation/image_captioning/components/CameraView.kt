package com.devscion.classy.presentation.image_captioning.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devscion.classy.utils.PlatformStorableImage
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.orEmpty
import org.jetbrains.compose.resources.rememberImageBitmap
import org.jetbrains.compose.resources.resource
import java.util.*
import androidx.compose.ui.Modifier
import com.devscion.classy.domain.model.PictureData
import com.devscion.classy.domain.model.createCameraPictureData
import com.devscion.classy.utils.CircularButton
import com.devscion.classy.utils.DesktopStorableImage
import com.devscion.classy.utils.IconPhotoCamera
import com.devscion.classy.utils.createNewPhotoNameAndDescription

@OptIn(ExperimentalResourceApi::class)
@Composable
actual fun CameraView(
    modifier: Modifier,
    onCapture: (picture: PictureData.Camera, image: PlatformStorableImage) -> Unit
) {
    Box(Modifier.fillMaxSize().background(Color.Black)) {
        Text(
            text = """
                Camera is not available on Desktop for now.
            """.trimIndent(),
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
                .background(
                    color = Color.Black.copy(alpha = 0.7f),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(20.dp)
        )
        val nameAndDescription = createNewPhotoNameAndDescription()
        CircularButton(
            imageVector = IconPhotoCamera,
            modifier = Modifier.align(Alignment.BottomCenter).padding(36.dp),
        ) {
//            onCapture(
//                createCameraPictureData(
//                    name = nameAndDescription.name,
//                    description = nameAndDescription.description,
//                ),
//                DesktopStorableImage(imageBitmap)
//            )
        }
    }
}
