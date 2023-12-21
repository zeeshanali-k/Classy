package com.devscion.classy

import androidx.compose.ui.window.ComposeUIViewController


fun MainViewController() = ComposeUIViewController { App() }



actual fun getPlatform() : Int = 1