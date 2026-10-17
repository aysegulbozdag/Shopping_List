package com.app.shoppinglist.ui.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.shoppinglist.ui.ui.productlist.ProductListScreen


@Composable
fun NavigationPage(modifier: androidx.compose.ui.Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            ProductListScreen(modifier, onNavigateToBasket = { totalAmount ->
                navController.navigate("basket/${totalAmount}")
            })
        }
        composable(
            "basket/{totalAmaount}", arguments = listOf(
                navArgument("totalAmaount") { type = NavType.StringType }
            )) { backStackEntry ->
            val totalAmount = backStackEntry.arguments?.getString("totalAmaount")
            BasketScreen(modifier = modifier, totalAmount = totalAmount)
        }
    }
}