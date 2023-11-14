package com.globant.design.atoms

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.design.theme.White

@Composable
fun Button(
    modifier: Modifier = Modifier,
    value: String,
    color: Color = Color.Unspecified,
    textColor: Color = White,
    onClick: () -> Unit = {},
) {
    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            modifier = Modifier.align(CenterVertically).padding(8.dp),
            text = value,
            fontWeight = FontWeight.Bold,
            color = textColor,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun ButtonPreview() {
    val context = LocalContext.current
    Button(
        onClick = { Toast.makeText(context, "Press me", Toast.LENGTH_SHORT).show() },
        value = "Press me",
    )
}
