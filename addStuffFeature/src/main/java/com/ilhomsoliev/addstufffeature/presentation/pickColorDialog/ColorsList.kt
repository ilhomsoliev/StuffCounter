package com.ilhomsoliev.addstufffeature.presentation.pickColorDialog

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorsList(
    modifier: Modifier = Modifier,
    listOfColors: List<Color>,
    activeColor: Color,
    onClick: (Color) -> Unit,
) {
    Row(modifier = modifier) {
        LazyRow {
            items(listOfColors) {

                CustomColoredCircle(color = it, isActive = it == activeColor, onClick = {
                    onClick(it)
                })

                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}