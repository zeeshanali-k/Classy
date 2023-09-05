package com.devscion.classy.presentation.images_history

import com.devscion.classy.db.Image

data class ImagesHistoryState(
    val images: List<Image> = listOf(),
    val isLoading: Boolean = false,
    val error: String = ""
)