package io.devexpert.nav3samples.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import io.devexpert.nav3samples.ui.theme.screens.detail.ProductDetail
import io.devexpert.nav3samples.ui.theme.screens.detail.ProductDetailScreen
import io.devexpert.nav3samples.ui.theme.screens.home.Home

@Composable
fun Navigation() {

    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Home> {
                Home(
                    onProductClick = { productId ->
                        backStack.add(ProductDetail(productId))
                    }
                )
            }
            entry<ProductDetail> { key ->
                ProductDetailScreen(
                    productId = key.productId,
                    onBackClick = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}