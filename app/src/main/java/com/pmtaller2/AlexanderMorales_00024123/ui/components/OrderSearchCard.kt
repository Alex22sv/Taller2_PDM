package com.pmtaller2.AlexanderMorales_00024123.ui.components

import android.widget.Toast
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.pmtaller2.AlexanderMorales_00024123.R
import com.pmtaller2.AlexanderMorales_00024123.local.OrderViewModel
import com.pmtaller2.AlexanderMorales_00024123.model.Order
import com.pmtaller2.AlexanderMorales_00024123.model.Restaurant
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun OrderSearchCard(
    order: Order,
    navController: NavController,
    viewModel: OrderViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                imageModel = {
                    order.dish.imageUrl
                },
                modifier = Modifier
                    .size(150.dp),
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
                    )
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .height(150.dp)
            ){
                Text(
                    text = order.dish.name,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
                    color = MaterialTheme.colors.background
                )
                Text(
                    text = "From ${order.restaurant.name}",
                    style = TextStyle(fontSize = 14.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    color = MaterialTheme.colors.background
                )
                val context = LocalContext.current
                Button(
                    modifier = Modifier.padding(8.dp),
                    onClick = {
                        viewModel.removeOrder(order)
                        Toast.makeText(context, "Order removed", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text("Remove")
                }

            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
