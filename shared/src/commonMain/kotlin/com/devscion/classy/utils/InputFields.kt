package com.devscion.classy.utils

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun ClassicInputField(
    modifier: Modifier = Modifier,
    hint: String,
    value: String,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value, onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        placeholder = {
            SmallLowGreyText(text = hint)
        },
        keyboardOptions = keyboardOptions,
        colors = InputFieldTransparentDesign(),
        textStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            color = Color(0xFF000000),
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        ),
    )
}


@Composable
fun InputFieldTransparentDesign() = TextFieldDefaults.textFieldColors(
    backgroundColor = Color.Transparent,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    disabledIndicatorColor = Color.Transparent,
    cursorColor = Color(0xFF000000),
)


@Composable
fun SmallLowGreyText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            color = Color(0x73777778),
            fontSize = 14.sp
        ),
    )
}
