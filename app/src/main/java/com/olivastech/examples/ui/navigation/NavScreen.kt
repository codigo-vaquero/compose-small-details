package com.olivastech.examples.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
sealed class NavScreen {
    abstract val route: String
    abstract val title: String
    abstract val icon: ImageVector

    @Serializable
    object Buttons : NavScreen() {
        override val route = "buttons"
        override val title = "Botones"
        override val icon = Icons.Default.PlayArrow
    }

    @Serializable
    object Lists : NavScreen() {
        override val route = "lists"
        override val title = "Listas"
        override val icon = Icons.Default.List
    }

    @Serializable
    object TextFields : NavScreen() {
        override val route = "textfields"
        override val title = "Campos"
        override val icon = Icons.Default.Edit
    }
}

val bottomNavItems = listOf(NavScreen.Buttons, NavScreen.Lists, NavScreen.TextFields)
