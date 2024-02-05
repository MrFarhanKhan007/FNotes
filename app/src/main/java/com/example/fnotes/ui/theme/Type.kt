package com.example.fnotes.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fnotes.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val visby = FontFamily(
    Font(R.font.visbybold),
    Font(R.font.visbyextrabold),
    Font(R.font.visbyextralight),
    Font(R.font.visbyheavy),
    Font(R.font.visbylight),
    Font(R.font.visbymedium),
    Font(R.font.visbyrregular),
    Font(R.font.visbysemibold),

    )