package com.globant.design.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.globant.design.R
import com.globant.design.atoms.Text
import com.globant.design.theme.Gray
import com.globant.design.theme.LightGray
import com.globant.design.theme.White

@Composable
fun Option(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    Column(modifier = modifier.fillMaxWidth().background(White).clickable { onClick() }) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = text,
                fontWeight = FontWeight.Bold,
            )
            Icon(
                modifier = Modifier.align(Alignment.CenterEnd).size(32.dp),
                painter = painterResource(id = R.drawable.ic_forward_arrow),
                contentDescription = "Arrow",
                tint = Gray,
            )
        }
        Divider(color = LightGray, thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
internal fun OptionPreview() {
    Option(text = "Cines favoritos")
}
