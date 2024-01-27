package com.example.fnotes.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fnotes.ui.theme.visby

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: MutableState<String>
) {
    val localKeyboardController = LocalSoftwareKeyboardController.current
    BasicTextField(
        value = value.value,
        onValueChange = {
            value.value = it
        },
        modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(75.dp),
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontFamily = visby
        ),
        enabled = true,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            //just close the keyboard
            onDone = {
                localKeyboardController?.hide()
            }
        ),
        singleLine = false,
        minLines = 1,
        maxLines = 100,
    )
}
