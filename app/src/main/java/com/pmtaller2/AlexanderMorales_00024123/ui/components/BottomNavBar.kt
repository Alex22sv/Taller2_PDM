package com.pmtaller2.AlexanderMorales_00024123.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddToPhotos
import androidx.compose.material.icons.outlined.Diamond
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.NoteAlt
import androidx.compose.material.icons.outlined.Notes
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pmtaller2.AlexanderMorales_00024123.navigation.Routes


@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    currentRoute: String,
    onItemClick: (String) -> Unit
) {
    val items = listOf(
        Icons.Outlined.Home,
        Icons.Outlined.Search,
        Icons.Outlined.AddToPhotos
    )

    // Rutas correspondientes
    val routes = listOf(Routes.HOME, "search/0", Routes.ORDERS)

    // Etiquetas bajo de los íconos
    val labels = listOf("home", "search", "orders")

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, icon ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = labels[index],
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = { Text(labels[index]) },
                selected = currentRoute == routes[index],
                onClick = { onItemClick(routes[index]) }
            )
        }
    }
}
