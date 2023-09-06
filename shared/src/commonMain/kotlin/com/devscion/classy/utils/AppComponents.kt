package com.devscion.classy.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.devscion.classy.ui.LARGE_PADDING
import com.devscion.classy.ui.SMALL_PADDING
import com.devscion.classy.ui.STANDARD_SPACING


@Composable
fun RoundedCardBgBox(
    modifier: Modifier = Modifier,
    isLowPadding: Boolean = false,
    customPadding: Dp? = null,
    content: @Composable () -> Unit,
) {

    Box(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(STANDARD_SPACING))
            .background(Color(0xFFD2D4DC))
            .padding(
                customPadding ?: (if (isLowPadding) SMALL_PADDING else
                    LARGE_PADDING)
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }

}