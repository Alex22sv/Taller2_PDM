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
import androidx.navigation.NavController
import com.pmtaller2.AlexanderMorales_00024123.local.restaurants
import com.pmtaller2.AlexanderMorales_00024123.local.OrderViewModel
import com.pmtaller2.AlexanderMorales_00024123.ui.components.BottomNavBar
import com.pmtaller2.AlexanderMorales_00024123.ui.components.DishSearchCard
import com.pmtaller2.AlexanderMorales_00024123.ui.components.RestaurantSearchCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen (
    navController: NavController,
    restaurantId: String,
    viewModel: OrderViewModel
    /* viewModel: BookViewModel = viewModel() */
) {
    var restaurant = restaurants.find { it.id == restaurantId.toInt() }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(restaurant?.name ?: "Restaurants") }
            )
        },
        bottomBar = {
            BottomNavBar(
                currentRoute = "search/0.",
                onItemClick = { route -> navController.navigate(route) }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.onBackground),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if(restaurant == null || restaurantId.isEmpty()) {
                        var restaurantSearch by remember { mutableStateOf("") }
                        TextField(
                            value = restaurantSearch,
                            onValueChange = { restaurantSearch = it },
                            label = { Text("Search restaurants") },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        if(!restaurantSearch.isEmpty()) {
                            val filteredRestaurants = restaurants.mapNotNull { restaurant ->
                                val nameMatch = restaurant.name.contains(restaurantSearch, ignoreCase = true)
                                val categoryMatch = restaurant.categories.any { it.contains(restaurantSearch, ignoreCase = true) }
                                val dishMatch = restaurant.menu.any { it.name.contains(restaurantSearch, ignoreCase = true) }

                                val score = when {
                                    nameMatch -> 3
                                    categoryMatch -> 2
                                    dishMatch -> 1
                                    else -> 0
                                }

                                if (score > 0) restaurant to score else null
                            }.sortedByDescending { it.second }.map { it.first }
                            Text(
                                text = "Found ${filteredRestaurants.size} restaurants",
                                color = MaterialTheme.colorScheme.background,
                                style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic)
                            )
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                items(filteredRestaurants.size) { index ->
                                    RestaurantSearchCard(restaurant = filteredRestaurants[index], navController = navController)
                                }
                            }
                        } else {
                            Text(
                                text = "Displaying all restaurants",
                                color = MaterialTheme.colorScheme.background,
                                style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic)
                            )
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                items(restaurants.size) { index ->
                                    RestaurantSearchCard(restaurant = restaurants[index], navController = navController)
                                }
                            }
                        }
                    } else {
                        var menuSearch by remember { mutableStateOf("") }
                        TextField(
                            value = menuSearch,
                            onValueChange = { menuSearch = it },
                            label = { Text("Search menu") },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        if(!menuSearch.isEmpty()) {
                            val filteredDishes = restaurant?.menu?.filter { it.name.contains(menuSearch, ignoreCase = true) }
                            Text(
                                text = "Found ${filteredDishes?.size} dishes",
                                color = MaterialTheme.colorScheme.background,
                                style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic)
                            )
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                if (filteredDishes != null) {
                                    items(filteredDishes.size) { index ->
                                        DishSearchCard(dish = filteredDishes[index], restaurant = restaurant, navController = navController, viewModel = viewModel)
                                    }
                                }

                            }
                        } else {
                            Text(
                                text = "Displaying menu",
                                color = MaterialTheme.colorScheme.background,
                                style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic)
                            )
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                items(restaurant.menu.size) { index ->
                                    DishSearchCard(dish = restaurant.menu[index], restaurant = restaurant, navController = navController, viewModel = viewModel)
                                }

                            }
                        }
                    }
                }
            }
        }
    )
}
