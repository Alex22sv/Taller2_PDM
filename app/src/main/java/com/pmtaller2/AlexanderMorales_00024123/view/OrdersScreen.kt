package com.pmtaller2.AlexanderMorales_00024123.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.pmtaller2.AlexanderMorales_00024123.local.OrderViewModel
import com.pmtaller2.AlexanderMorales_00024123.local.restaurants
import com.pmtaller2.AlexanderMorales_00024123.model.Dish
import com.pmtaller2.AlexanderMorales_00024123.model.Order
import com.pmtaller2.AlexanderMorales_00024123.navigation.Routes
import com.pmtaller2.AlexanderMorales_00024123.ui.components.BottomNavBar
import com.pmtaller2.AlexanderMorales_00024123.ui.components.HomePageSection
import com.pmtaller2.AlexanderMorales_00024123.ui.components.OrderSearchCard
import com.pmtaller2.AlexanderMorales_00024123.ui.components.RestaurantSearchCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersScreen(
    navController: NavController,
    viewModel: OrderViewModel
) {
    var orders = viewModel.orders
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My orders") }
            )
        },
        bottomBar = {
            BottomNavBar(
                currentRoute = navController.currentBackStackEntry?.destination?.route ?: Routes.ORDERS,
                onItemClick = { route -> navController.navigate(route) }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {

                if(orders.isEmpty()) {
                 Column(
                     modifier = Modifier
                         .fillMaxSize()
                         .padding(8.dp),
                     verticalArrangement = Arrangement.Center,
                     horizontalAlignment = Alignment.CenterHorizontally,
                 ) {
                     Text(
                         text = "No orders found",
                         color = MaterialTheme.colorScheme.background,
                         style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic)
                     )
                 }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    if(orders.isNotEmpty()) {
                        var ordersSearch by remember { mutableStateOf("") }
                        TextField(
                            value = ordersSearch,
                            onValueChange = { ordersSearch = it },
                            label = { Text("Search orders") },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        if(!ordersSearch.isEmpty()) {
                            val filteredOrders: List<Order> = orders.mapNotNull { order ->
                                val nameMatch = order.dish.name.contains(ordersSearch, ignoreCase = true)
                                val restaurantMatch = order.restaurant.name.contains(ordersSearch, ignoreCase = true)

                                val score = when {
                                    nameMatch -> 2
                                    restaurantMatch -> 1
                                    else -> 0
                                }

                                if (score > 0) order to score else null
                            }.sortedByDescending { it.second }.map { it.first }
                            Text(
                                text = "Found ${filteredOrders.size} orders",
                                color = MaterialTheme.colorScheme.background,
                                style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic)
                            )
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                items(filteredOrders.size) { index ->
                                    OrderSearchCard(order = filteredOrders[index], navController = navController, viewModel = viewModel)
                                }
                            }
                        } else {
                            Text(
                                text = "Displaying all orders",
                                color = MaterialTheme.colorScheme.background,
                                style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic)
                            )
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                items(orders.size) { index ->
                                    OrderSearchCard(order = orders[index], navController = navController, viewModel = viewModel)
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}