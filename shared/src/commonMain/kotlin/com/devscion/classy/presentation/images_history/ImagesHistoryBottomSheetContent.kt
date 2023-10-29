package com.devscion.classy.presentation.images_history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.devscion.classy.db.Image
import com.devscion.classy.presentation.images_history.components.ImageDetailsDialog
import com.devscion.classy.presentation.images_history.components.ImageListItem
import com.devscion.classy.presentation.text_to_image.TextToImageViewModel
import com.devscion.classy.ui.STANDARD_ICON_SIZE
import com.devscion.classy.ui.STANDARD_PADDING
import com.devscion.classy.ui.STANDARD_SPACING
import com.devscion.classy.utils.Vertical
import com.mohamedrejeb.calf.ui.progress.AdaptiveCircularProgressIndicator


@Composable
fun ImagesHistoryBottomSheetContent(
    viewModel: TextToImageViewModel,
    onClosed: () -> Unit,
) {

    val imagesState = viewModel.imagesStateState.collectAsState().value

    val detailImage = remember {
        mutableStateOf<Image?>(null)
    }
    Column(
        Modifier.fillMaxSize()
            .padding(STANDARD_PADDING),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (imagesState.isLoading) {
            AdaptiveCircularProgressIndicator()
        } else if (imagesState.error.isEmpty() && imagesState.images.isNotEmpty()) {
            Box(
                Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = onClosed,
                    modifier = Modifier.align(Alignment.CenterStart)
                        .size(STANDARD_ICON_SIZE)
                ) {
                    Icon(Icons.Rounded.Close, "")
                }

                Text(
                    "Images History",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            STANDARD_SPACING.Vertical()
            LazyVerticalGrid(
                GridCells.FixedSize(150.dp),
                modifier = Modifier.fillMaxSize()
                    .align(Alignment.CenterHorizontally),
            ) {
                items(imagesState.images) {
                    ImageListItem(it.imageBase64) {
//                        onShowImageDetails(it)
                        detailImage.value = it
                    }
                }
            }
        } else if (imagesState.error.isNotEmpty()) {
            Text(
                imagesState.error, style = TextStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
        } else if (imagesState.images.isEmpty()) {
            Text(
                "No images found", style = TextStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
        }
        if (detailImage.value != null) {
            Dialog(onDismissRequest = {
                detailImage.value = null
            }) {
                ImageDetailsDialog(detailImage.value!!)
            }
        }
    }

}