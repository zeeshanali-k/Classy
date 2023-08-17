package com.devscion.classy.presentation.home

data class HomeState(
    val image: ByteArray? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
