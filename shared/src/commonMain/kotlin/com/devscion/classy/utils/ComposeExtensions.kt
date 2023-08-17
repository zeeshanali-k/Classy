package com.devscion.classy.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp


@Composable
fun Dp.Horizontal() {
    Spacer(modifier = Modifier.width(this))
}

@Composable
fun Dp.Vertical() {
    Spacer(modifier = Modifier.height(this))
}