package com.pmtaller2.AlexanderMorales_00024123.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.pmtaller2.AlexanderMorales_00024123.local.restaurants
import com.pmtaller2.AlexanderMorales_00024123.model.Dish
import com.pmtaller2.AlexanderMorales_00024123.model.Restaurant
import com.pmtaller2.AlexanderMorales_00024123.navigation.Routes
import com.pmtaller2.AlexanderMorales_00024123.ui.components.BottomNavBar
import com.pmtaller2.AlexanderMorales_00024123.ui.components.HomePageSection
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    /* viewModel: BookViewModel = viewModel() */
) {

    val categories = restaurants.flatMap { it.categories }.distinct()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FoodSpot By Efraín") }
            )
        },
        bottomBar = {
            BottomNavBar(
                currentRoute = navController.currentBackStackEntry?.destination?.route ?: Routes.HOME,
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
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(categories.size) { index ->
                        val restaurantsInCategory = restaurants.filter { it.categories.contains(categories[index]) }
                        if (restaurantsInCategory.isNotEmpty()) {
                            HomePageSection(
                                title = categories[index],
                                restaurants = restaurantsInCategory,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    )
}
