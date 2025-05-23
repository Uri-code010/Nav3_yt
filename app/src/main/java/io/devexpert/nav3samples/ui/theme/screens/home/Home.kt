package io.devexpert.nav3samples.ui.theme.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable

@Serializable
data object Home

@Composable
fun Home() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(text = "Home", modifier = Modifier.padding(innerPadding))
    }
}