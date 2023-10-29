package com.devscion.classy.presentation.text_to_image

data class TextToImageState(
    val image: ByteArray? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
