package com.codesodja.modernhomeui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
        primary = background,
        primaryVariant = DarkGreen,
        secondary = AquaGreen
)

private val LightColorPalette = lightColors(
        primary = background,
        primaryVariant = DarkGreen,
        secondary = AquaGreen
)

@Composable
fun ModernHomeuiTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}