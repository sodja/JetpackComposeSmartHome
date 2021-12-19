package com.codesodja.modernhomeui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codesodja.modernhomeui.R

val montserrat = FontFamily(
        listOf(
                Font(R.font.montserrat_regular, FontWeight.Normal),
                Font(R.font.montserrat_medium, FontWeight.Medium),
                Font(R.font.montserrat_semibold, FontWeight.SemiBold),
                Font(R.font.montserrat_bold, FontWeight.Bold),
                Font(R.font.montserrat_black, FontWeight.Black),
                Font(R.font.montserrat_light, FontWeight.Light),
        )
)

val Typography = Typography(
        body1 = TextStyle(
                color = TextWhite,
                fontFamily = montserrat,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        ), body2 = TextStyle(
                color = FontFamilyColor,
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
        ),
        h1 = TextStyle(
                color = TextWhite,
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
        ),
        h2 = TextStyle(
                color = TextWhite,
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
        ),
        h3 = TextStyle(
                color = TextWhite,
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
        ),
        h4 = TextStyle(
                color = TextWhite,
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
        ),
        h5 = TextStyle(
                color = TextWhite,
                fontFamily = montserrat,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
        ),
        h6 = TextStyle(
                color = FontFamilyColor,
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
        ),
        /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)