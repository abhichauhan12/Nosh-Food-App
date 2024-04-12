package com.abhishek.foodapp.sidenav

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    @DrawableRes val icon: Int,
    val selected: Boolean,
    )
