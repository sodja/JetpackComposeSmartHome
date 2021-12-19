package com.codesodja.modernhomeui.model

import androidx.annotation.DrawableRes

data class DetailsContent(
    val title: String,
    val code: String,
    @DrawableRes val iconId: Int
)
