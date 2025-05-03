package com.pmtaller2.AlexanderMorales_00024123.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pmtaller2.AlexanderMorales_00024123.model.Restaurant


@Composable
fun HomePageSection(title: String, restaurants: List<Restaurant>, navController: NavController) {
    Column(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                color = MaterialTheme.colors.onSecondary,
                textAlign = TextAlign.Start,
            )
        }
        LazyRow(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
        ) {
            items(restaurants.size) { index ->
                Column(
                    modifier = Modifier
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ClickableImage(restaurants[index], navController)
                    Text(
                        text = restaurants[index].name,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 8.dp)
                            .clickable{ navController.navigate("search/${restaurants[index].id}") },
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colors.onSecondary,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}