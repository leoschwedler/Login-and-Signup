package com.example.loginandsignup.commom.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginandsignup.R

@Composable
fun PrimaryTextField(
    modifier: Modifier = Modifier,
    value: String,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isErrorMessage: String? = null,
    isError: Boolean = false
) {
    var isVisiblePassword by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            isError = isError,
            modifier = modifier.fillMaxWidth(),
            onValueChange = onValueChange,
            value = value,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            singleLine = true,
            minLines = 1,
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFF626262)),
            placeholder = {
                Text(text = placeholder)
            },
            visualTransformation = if (keyboardType == KeyboardType.Password) {
                if (isVisiblePassword) {
                    VisualTransformation.None

                } else {
                    PasswordVisualTransformation()
                }
            } else {
                VisualTransformation.None
            },
            trailingIcon = {
                if (keyboardType == KeyboardType.Password && value.isNotBlank()) {
                    val iconVisibility = if (isVisiblePassword) {
                        R.drawable.ic_visibility_off
                    } else {
                        R.drawable.ic_visibility
                    }
                    IconButton(onClick = { isVisiblePassword = !isVisiblePassword }) {
                        Icon(painter = painterResource(iconVisibility), contentDescription = null)
                    }
                }
            },
            shape = MaterialTheme.shapes.small,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF1F4FF),
                unfocusedContainerColor = Color(0xFFF1F4FF),
                unfocusedBorderColor = Color.Transparent,
                errorBorderColor = Color.Red,
                focusedBorderColor = Color(0xFF1F41BB),
                focusedTrailingIconColor = Color(0xFF626262),
                unfocusedTrailingIconColor = Color(0xFF626262),

                )
        )
        isErrorMessage?.let {
            Text(text = isErrorMessage, color = Color.Red)
        }
    }

}

@Preview
@Composable
private fun PrimaryTextFieldPreview() {

    PrimaryTextField(
        value = "",
        keyboardType = KeyboardType.Email,
        imeAction = ImeAction.Next,
        onValueChange = {},
        placeholder = "Email"
    )

}