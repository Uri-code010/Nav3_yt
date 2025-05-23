package io.devexpert.nav3samples.ui.theme.screens

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import io.devexpert.nav3samples.ui.theme.screens.detail.ProductDetail
import io.devexpert.nav3samples.ui.theme.screens.detail.ProductDetailScreen
import io.devexpert.nav3samples.ui.theme.screens.detail.ProductDetailViewModel
import io.devexpert.nav3samples.ui.theme.screens.home.Home

@Composable
fun Navigation() {

    val backStack = rememberNavBackStack(Home)

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
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
                    viewModel = viewModel { ProductDetailViewModel(key.productId) },
                    onBackClick = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}