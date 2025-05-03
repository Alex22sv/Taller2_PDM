package com.pmtaller2.AlexanderMorales_00024123.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pmtaller2.AlexanderMorales_00024123.local.OrderViewModel
import com.pmtaller2.AlexanderMorales_00024123.view.HomeScreen
import com.pmtaller2.AlexanderMorales_00024123.view.OrdersScreen
import com.pmtaller2.AlexanderMorales_00024123.view.SearchScreen

object Routes {
    const val HOME = "home"
    const val SEARCH = "search/{restaurantId}"
    const val ORDERS = "orders"
}

@Composable
fun NavGraph(startDestination: String = Routes.HOME) {
    val navController = rememberNavController()
    var viewModel: OrderViewModel = viewModel()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.HOME) {
            HomeScreen(navController = navController)
        }
        composable(
            Routes.SEARCH,
            arguments = listOf(navArgument("restaurantId") { type = NavType.StringType })
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getString("restaurantId")
            SearchScreen(navController = navController, restaurantId = restaurantId ?: "", viewModel = viewModel)
        }
        composable(Routes.ORDERS) {
            OrdersScreen(navController = navController, viewModel = viewModel)
        }
    }
}