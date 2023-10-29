package com.devscion.classy.presentation.image_annotation

data class ImageToTextState(
    val text: String? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
