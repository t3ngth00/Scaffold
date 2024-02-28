package com.example.scaffold

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.contentValuesOf
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.example.scaffold.ui.theme.ScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTheme {
                ScaffoldApp()
            }
        }
    }
}

@Composable
fun ScaffoldApp() {
    Scaffold (
        topBar = { MyTopBar() },
        content = { paddingValues ->
            Log.d("PaddingValues","$paddingValues")
            Box(modifier = Modifier.fillMaxSize()
                .padding(paddingValues))
            {Text(text = "Content for Home screen")}}
//        bottomBar = { BottomAppBar {
//            Text(text = "Bottom bar")
//        }}

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar () {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text("My App")},
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ },
                ) {
                Icon(Icons.Filled.Menu,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
               Icon(Icons.Filled.MoreVert,
                   contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false}) {
                DropdownMenuItem(text = { Text(text = "Info")}, onClick = { /*TODO*/ })
                DropdownMenuItem(text = { Text(text = "Setting")}, onClick = { /*TODO*/ })
            }
        }
        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScaffoldTheme {
        ScaffoldApp()
    }
}

