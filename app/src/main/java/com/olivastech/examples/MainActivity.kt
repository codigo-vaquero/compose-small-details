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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.olivastech.examples.ui.theme.SmallDetailsTheme
import dev.chiksmedina.Solar
import dev.chiksmedina.solar.Linear
import dev.chiksmedina.solar.linear.Search
import dev.chiksmedina.solar.linear.search.Magnifer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmallDetailsTheme {
                var someText by remember { mutableStateOf("") }
                var isError by remember { mutableStateOf(false) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        StandardSearchBar(
                            value = someText,
                            onValueChange = {
                                someText = it
                                isError = false
                            },
                            isError = isError
                        )
                        ContentArea(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth(),
                            onClickValidate = {
                                if (someText.isEmpty()) isError = true
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StandardSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            isError = isError,
            label = { Text("Write something here...") },
            modifier = Modifier.weight(1f),
            leadingIcon = {
                Icon(
                    imageVector = Solar.Linear.Search.Magnifer,
                    contentDescription = "Icono de usuario"
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorIndicatorColor = Color(0xFFFFA500)
            )
        )
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
    SmallDetailsTheme {
        StandardSearchBar(
            value = "",
            onValueChange = {},
            isError = false
        )
    }
}
