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
    isErrorMessage: String? = null
) {
    var isVisiblePassword by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
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
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                }
            } else {
                VisualTransformation.None
            },
            trailingIcon = {
                val iconVisibility =
                    if (keyboardType == KeyboardType.Password && isVisiblePassword == true) {
                        R.drawable.ic_visibility
                    } else {
                        R.drawable.ic_visibility_off
                    }
                IconButton(onClick = { isVisiblePassword = !isVisiblePassword }) {
                    Icon(painter = painterResource(iconVisibility), contentDescription = null)
                }
            },
            shape = MaterialTheme.shapes.small,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF1F4FF),
                unfocusedContainerColor = Color(0xFFF1F4FF),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color(0xFF1F41BB),
                focusedTrailingIconColor = Color(0xFF626262),
                unfocusedTrailingIconColor = Color(0xFF626262),
            )
        )
        isErrorMessage?.let {
            Text(text = isErrorMessage)
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