package com.mohaberabi.kmpessentials.theme


import androidx.compose.ui.unit.sp


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color

val BaseTypography = Typography(
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 34.sp
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp
    )
)

fun getAppTypography(mode: ThemeMode): Typography {
    val color = if (mode == ThemeMode.Dark) Color.White else Color.Black
    return BaseTypography.apply {
        copy(
            bodyLarge = bodyLarge.copy(color = color),
            headlineMedium = headlineMedium.copy(color = color),
            titleSmall = titleSmall.copy(color = color)
        )
    }

}

val AppTypographyLight = getAppTypography(ThemeMode.Light)
val AppTypographyDark = getAppTypography(ThemeMode.Dark)
