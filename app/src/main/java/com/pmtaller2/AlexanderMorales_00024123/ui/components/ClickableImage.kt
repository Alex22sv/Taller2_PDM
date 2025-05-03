package com.pmtaller2.AlexanderMorales_00024123.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pmtaller2.AlexanderMorales_00024123.model.Restaurant
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.pmtaller2.AlexanderMorales_00024123.R

@Composable
fun ClickableImage(restaurant: Restaurant, navController: NavController){
    GlideImage(
        imageModel = {
            restaurant.imageUrl
        },
        modifier = Modifier
            .fillMaxWidth()
            .size(150.dp)
            .clickable{ navController.navigate("search/${restaurant.id}") },
        imageOptions = ImageOptions(
            contentScale = ContentScale.Fit
        ),
        loading = {
            CircularProgressIndicator()
        },
        failure = {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                contentDescription = "Default img",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clickable{
                        navController.navigate("search/${restaurant.id}")
                    }
            )
        }
    )
}