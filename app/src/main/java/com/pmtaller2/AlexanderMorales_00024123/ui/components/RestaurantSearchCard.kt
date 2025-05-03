package com.pmtaller2.AlexanderMorales_00024123.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddToPhotos
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pmtaller2.AlexanderMorales_00024123.R
import com.pmtaller2.AlexanderMorales_00024123.model.Restaurant
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun RestaurantSearchCard(
    restaurant: Restaurant,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable{ navController.navigate("search/${restaurant.id}") }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                imageModel = {
                    restaurant.imageUrl
                },
                modifier = Modifier
                    .size(150.dp)
                    .clickable{ navController.navigate("search/${restaurant.id}") },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.FillHeight
                ),
                loading = {
                    CircularProgressIndicator()
                },
                failure = {
                    Image(
                        painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                        contentDescription = "Default img",
                        modifier = Modifier
                            .size(150.dp)
                            .clickable{
                                navController.navigate("search/${restaurant.id}")
                            }
                    )
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .height(150.dp)
            ){
                Text(
                    text = restaurant.name,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
                    color = MaterialTheme.colors.background
                )
                Text(
                    text = restaurant.description,
                    style = TextStyle(fontSize = 14.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    color = MaterialTheme.colors.background
                )
                Text(
                    text = "Categories: ${restaurant.categories.joinToString(separator = ", ")}",
                    style = TextStyle(fontSize = 14.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    color = MaterialTheme.colors.background
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
