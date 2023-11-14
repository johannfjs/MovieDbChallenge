package com.globant.design.atoms

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.globant.design.R
import com.globant.design.theme.White

@Composable
fun IconWithCircle(
    modifier: Modifier = Modifier,
    backgroundColor: Color = White,
    @DrawableRes painterResource: Int,
    onClick: () -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(64.dp)
            .background(
                color = backgroundColor,
                shape = CircleShape,
            ).clickable { onClick() },
    ) {
        Icon(
            painter = painterResource(id = painterResource),
            contentDescription = "contentDescription",
            modifier = Modifier
                .size(32.dp),
            tint = Color.Unspecified,
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun IconWithCirclePreview() {
    IconWithCircle(
        backgroundColor = White,
        painterResource = R.drawable.ic_profile,
    )
}
