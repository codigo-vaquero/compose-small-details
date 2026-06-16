package com.olivastech.examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.olivastech.examples.ui.theme.SmallDetailsTheme
import dev.chiksmedina.Solar
import dev.chiksmedina.solar.Linear
import dev.chiksmedina.solar.linear.BuildingInfrastructure
import dev.chiksmedina.solar.linear.Like
import dev.chiksmedina.solar.linear.Search
import dev.chiksmedina.solar.linear.Users
import dev.chiksmedina.solar.linear.buildinginfrastructure.Home
import dev.chiksmedina.solar.linear.like.Heart
import dev.chiksmedina.solar.linear.search.Magnifer
import dev.chiksmedina.solar.linear.users.UserCircle
import kotlinx.coroutines.launch
import com.olivastech.examples.TextFieldsView


class MainActivity : ComponentActivity() {
    val textFieldsView = TextFieldsView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmallDetailsTheme {
                var selectedTab by remember { mutableIntStateOf(0) }
                var someText by remember { mutableStateOf("") }
                var isError by remember { mutableStateOf(false) }
                var isValidated by remember { mutableStateOf(false) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = selectedTab == 0,
                                onClick = { selectedTab = 0 },
                                icon = { Icon(Solar.Linear.BuildingInfrastructure.Home, contentDescription = "Home") },
                                label = { Text("Home") }
                            )
                            NavigationBarItem(
                                selected = selectedTab == 1,
                                onClick = { selectedTab = 1 },
                                icon = { Icon(Solar.Linear.Search.Magnifer, contentDescription = "Search") },
                                label = { Text("Search") }
                            )
                            NavigationBarItem(
                                selected = selectedTab == 2,
                                onClick = { selectedTab = 2 },
                                icon = { Icon(Solar.Linear.Like.Heart, contentDescription = "Favorites") },
                                label = { Text("Favorites") }
                            )
                            NavigationBarItem(
                                selected = selectedTab == 3,
                                onClick = { selectedTab = 3 },
                                icon = { Icon(Solar.Linear.Users.UserCircle, contentDescription = "Profile") },
                                label = { Text("Profile") }
                            )
                        }
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        textFieldsView.StandardSearchBar(
                            value = someText,
                            onValueChange = {
                                someText = it
                                isError = false
                                isValidated = false
                            },
                            isError = isError,
                            isValidated = isValidated
                        )
                        ContentArea(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth(),
                            onClickValidate = {
                                if (someText.isEmpty()) {
                                    isError = true
                                    isValidated = false
                                } else {
                                    isError = false
                                    isValidated = true
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ContentArea(
    onClickValidate: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onClickValidate,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(text = "Validar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val textFieldsView = TextFieldsView()

    SmallDetailsTheme {
        textFieldsView.StandardSearchBar(
            value = "",
            onValueChange = {},
            isError = false,
            isValidated = false
        )
    }
}
