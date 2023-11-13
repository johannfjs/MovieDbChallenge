package com.globant.design.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.globant.design.model.ActionModel
import com.globant.design.molecules.Action

@Composable
fun ActionList(modifier: Modifier = Modifier, actions: List<ActionModel>) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(items = actions, itemContent = {
            Action(
                action = ActionModel(it.title, it.text, it.number),
            )
        })
    }
}
