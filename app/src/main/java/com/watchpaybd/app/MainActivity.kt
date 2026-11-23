package com.watchpaybd.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchPayApp()
        }
    }
}

@Composable
fun WatchPayApp() {
    var page by remember { mutableStateOf("Home") }

    MaterialTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    listOf("Home", "Watch", "Wallet", "Profile").forEach {
                        NavigationBarItem(
                            selected = page == it,
                            onClick = { page = it },
                            icon = { Text(it.take(1)) },
                            label = { Text(it) }
                        )
                    }
                }
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text("WatchPay BD",
                        style = MaterialTheme.typography.headlineLarge)
                    Spacer(Modifier.height(25.dp))
                    Text("Watch. Earn. Repeat.")
                    Spacer(Modifier.height(30.dp))

                    when (page) {
                        "Home" -> Text("Welcome to WatchPay BD!")
                        "Watch" -> Text("Approved Rewarded Ads will appear here.")
                        "Wallet" -> Text("Your Balance: ৳0.00")
                        "Profile" -> Text("Your Profile")
                    }
                }
            }
        }
    }
}
