package com.watchpaybd.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF101B2D)
private val Green = Color(0xFF21C58E)
private val Pale = Color(0xFFF3F6F8)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WatchPayApp() }
    }
}

@Composable
fun WatchPayApp() {
    var selected by remember { mutableStateOf(0) }
    MaterialTheme(colorScheme = lightColorScheme(primary = Green, background = Pale)) {
        Scaffold(
            containerColor = Pale,
            bottomBar = {
                NavigationBar(containerColor = Color.White) {
                    NavigationBarItem(selected == 0, { selected = 0 }, icon = { Icon(Icons.Default.Home, null) }, label = { Text("Home") })
                    NavigationBarItem(selected == 1, { selected = 1 }, icon = { Icon(Icons.Default.PlayCircle, null) }, label = { Text("Watch") })
                    NavigationBarItem(selected == 2, { selected = 2 }, icon = { Icon(Icons.Default.Wallet, null) }, label = { Text("Wallet") })
                    NavigationBarItem(selected == 3, { selected = 3 }, icon = { Icon(Icons.Default.AccountCircle, null) }, label = { Text("Profile") })
                }
            }
        ) { padding ->
            when (selected) {
                0 -> HomeScreen(Modifier.padding(padding))
                1 -> WatchScreen(Modifier.padding(padding))
                2 -> WalletScreen(Modifier.padding(padding))
                else -> ProfileScreen(Modifier.padding(padding))
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier.fillMaxSize().padding(18.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            Text("WatchPay BD", color = Navy, fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Text("Watch • Learn • Earn", color = Color.Gray)
        }
        item {
            Column(Modifier.fillMaxWidth().background(Navy, RoundedCornerShape(22.dp)).padding(22.dp)) {
                Text("Available balance", color = Color.LightGray)
                Text("৳ 0.00", color = Color.White, fontSize = 34.sp, fontWeight = FontWeight.Bold)
                Text("Your verified rewards will appear here", color = Color.LightGray, fontSize = 12.sp)
            }
        }
        item { Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            QuickCard("Watch Ads", "Rewarded ads")
            QuickCard("Invite", "Referral program")
        } }
        item {
            Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
                Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("Welcome to WatchPay BD", fontWeight = FontWeight.Bold, color = Navy)
                    Text("This is the app foundation. Account login, verified ad integration, server balance and withdrawals will be connected after the backend and ad-network permissions are set up.", color = Color.DarkGray)
                }
            }
        }
    }
}

@Composable
fun QuickCard(title: String, subtitle: String) {
    Card(modifier = Modifier.weight(1f), colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.Bold, color = Navy)
            Text(subtitle, color = Color.Gray, fontSize = 12.sp)
        }
    }
}

@Composable
fun WatchScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text("Watch Ads", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Navy)
        Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
            Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text("Rewarded video ads", fontWeight = FontWeight.Bold)
                Text("No ad provider is connected yet. We will only add a provider and reward flow that explicitly permits incentivized viewing.", color = Color.DarkGray)
                Button(onClick = {}, enabled = false, modifier = Modifier.fillMaxWidth()) { Text("Ads not available yet") }
            }
        }
    }
}

@Composable
fun WalletScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text("My Wallet", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Navy)
        Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
            Column(Modifier.padding(18.dp)) {
                Text("Current balance", color = Color.Gray)
                Text("৳ 0.00", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Navy)
                Text("No earnings or withdrawals are processed in this starter build.", color = Color.Gray)
            }
        }
        OutlinedButton(onClick = {}, enabled = false, modifier = Modifier.fillMaxWidth()) { Text("Request withdrawal — setup pending") }
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Profile", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Navy)
        Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
            Column(Modifier.padding(18.dp)) {
                Text("Guest account", fontWeight = FontWeight.Bold)
                Text("Registration, secure login and referral ID will be added with the backend.", color = Color.Gray)
            }
        }
    }
}
