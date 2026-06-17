package com.olivastech.examples.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute

@Composable
fun BottomNavBar(
    items: List<NavScreen>,
    currentDestination: NavDestination?,
    onItemClick: (NavScreen) -> Unit
) {
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hasRoute(screen::class) == true,
                onClick  = { onItemClick(screen) },
                icon     = { Icon(screen.icon, contentDescription = screen.title) },
                label    = { Text(screen.title) }
            )
        }
    }
}
