package com.olivastech.examples.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.olivastech.examples.ui.ButtonsView
import com.olivastech.examples.ui.ListsView
import com.olivastech.examples.ui.TextFieldsView

@Composable
fun AppNavigation(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = NavScreen.TextFields,
        modifier = Modifier.padding(padding)
    ) {
        composable<NavScreen.Buttons> { ButtonsView() }
        composable<NavScreen.Lists> { ListsView() }
        composable<NavScreen.TextFields> { TextFieldsView() }
    }
}
