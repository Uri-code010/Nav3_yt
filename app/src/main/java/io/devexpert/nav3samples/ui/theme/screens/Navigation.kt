package io.devexpert.nav3samples.ui.theme.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import io.devexpert.nav3samples.ui.theme.screens.home.Home

@Composable
fun Navigation() {

    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
    ) { key ->
        when (key) {
            Home -> NavEntry(key) {
                Home()
            }

            else -> NavEntry(Unit) {
                Text(text = "Unknown")
            }
        }
    }
}