package com.ilhomsoliev.core

import androidx.compose.ui.graphics.Color
import com.ilhomsoliev.theme.*

class Helper {
    companion object {
        fun getPreferredColors(): List<Color> = listOf(
            Red,
            Purple,
            Yellow,
            Black,
            Green,
        )

        fun getColorName(color: Color): String = when (color) {
            Red -> {
                "Red"
            }
            Purple -> {
                "Purple"
            }
            Yellow -> {
                "Yellow"
            }
            Black -> {
                "Black"
            }
            Green -> {
                "Green"
            }
            else -> ""
        }
    }
}