package com.mohaberabi.kmpessentials.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember


@Composable
fun AppTheme(
    mode: ThemeMode = ThemeMode.System,
    content: @Composable () -> Unit,
) {
    val isDark = isSystemInDarkTheme()
    val colorScheme = remember(mode) {
        when (mode) {
            ThemeMode.Light -> lightScheme
            ThemeMode.Dark -> darkScheme
            ThemeMode.System -> if (isDark) darkScheme else lightScheme
        }
    }

    val typo = remember(mode) {
        getAppTypography(mode)
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typo,
        content = content
    )
}