package com.codesodja.modernhomeui.model

import androidx.annotation.DrawableRes

data class Feature(
    val code: String,
    val title: String,
    @DrawableRes val image: Int
)
