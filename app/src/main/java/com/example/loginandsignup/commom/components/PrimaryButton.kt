package com.example.loginandsignup.commom.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginandsignup.R

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    icon: Int,
    onClick: () -> Unit
) {
    Button(onClick = onClick,
        modifier = modifier.height(45.dp).width(65.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFFECECEC),
        contentColor = Color.Black,
    )) {
        Icon(painter = painterResource(icon), contentDescription = null,modifier = Modifier.size(24.dp))
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    PrimaryButton(
        icon = R.drawable.ic_google,
        onClick = {}
    )

}