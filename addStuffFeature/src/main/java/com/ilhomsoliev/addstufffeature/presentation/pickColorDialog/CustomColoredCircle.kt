package com.ilhomsoliev.addstufffeature.presentation.pickColorDialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.theme.GrayBorder

@Composable
fun CustomColoredCircle(
    modifier: Modifier = Modifier.size(48.dp),
    color: Color = Color.Black,
    isActive: Boolean = false,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .background(color = color)
            .border(
                border = BorderStroke(if (isActive) 4.dp else 0.dp, color = GrayBorder),
                shape = RoundedCornerShape(100.dp)
            )
            .clickable {
                onClick()
            }
    ) {

    }
}