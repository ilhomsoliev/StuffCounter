package com.ilhomsoliev.homefeature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StuffItem(
    modifier: Modifier = Modifier,
    name: String,
    count: Int,
    backgroundColor: Color,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    onItemClick: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable {
                       onItemClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                onMinusClick()
            }) {
                Icon(imageVector = Icons.Default.Remove, contentDescription = null)
            }
        }

        Column {
            Text(text = name)
            Text(text = count.toString())
        }
        Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                onPlusClick()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    }

}