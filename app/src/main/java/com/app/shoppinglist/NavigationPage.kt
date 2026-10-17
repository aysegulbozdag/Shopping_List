package com.app.shoppinglist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.shoppinglist.data.Screen
import com.app.shoppinglist.ui.basket.BasketScreen
import com.app.shoppinglist.ui.productlist.ProductListScreen


@Composable
fun NavigationPage(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            ProductListScreen(modifier, onNavigateToBasket = { totalAmount ->
                navController.navigate("${Screen.BasketScreen.route}/$totalAmount")
            })
        }
        composable(
            route = "${Screen.BasketScreen.route}/{totalAmount}",
            arguments = listOf(
                navArgument("totalAmount") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val totalAmount = backStackEntry.arguments?.getString("totalAmount")
            BasketScreen(modifier = modifier, totalAmount = totalAmount)
        }
    }
}