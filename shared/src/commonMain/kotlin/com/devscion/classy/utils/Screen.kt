package com.devscion.classy.utils

sealed class Screen{
    data object Splash : Screen()
    data object Txt2Img : Screen()
    data object Menu : Screen()
    data object ImageCaptioning : Screen()
    data object ImageCaptioningResult : Screen()
}