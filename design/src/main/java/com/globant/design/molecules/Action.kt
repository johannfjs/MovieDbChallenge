package com.globant.design.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.design.model.ActionModel
import com.globant.design.theme.DarkGray
import com.globant.design.theme.Gray
import com.globant.design.theme.LightGray
import com.globant.design.theme.White

@Composable
fun Action(
    action: ActionModel,
    onClick: () -> Unit = {},
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.clickable { onClick() },
    ) {
        Column(
            modifier = Modifier.background(White).width(150.dp)
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp).background(LightGray)
                    .height(100.dp),
                text = action.text,
                fontSize = 10.sp,
                color = DarkGray,
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = action.title,
                fontSize = 12.sp,
                color = DarkGray,
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = action.number.toString(),
                fontSize = 12.sp,
                color = Gray,
            )
        }
    }
}
