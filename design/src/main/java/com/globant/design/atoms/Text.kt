package com.globant.design.atoms

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.globant.design.theme.robotoFamily

@Composable
fun Text(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight? = null,
    fontStyle: FontStyle? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    onClick: (() -> Unit)? = null,
) {
    androidx.compose.material3.Text(
        modifier = modifier.clickable(onClick != null) { onClick?.invoke() },
        text = text,
        fontFamily = robotoFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        fontStyle = fontStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow,
    )
}
