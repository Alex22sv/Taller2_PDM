package com.pmtaller2.AlexanderMorales_00024123.local

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.pmtaller2.AlexanderMorales_00024123.model.Dish
import com.pmtaller2.AlexanderMorales_00024123.model.Order
import com.pmtaller2.AlexanderMorales_00024123.model.Restaurant



var restaurants: MutableList<Restaurant> = mutableListOf(
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Best pizzas",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT02hMuq83unkTNSKHdZDEHDhEUnnYdsq5ljw&s",
        categories = listOf("Italian food", "Fast food", "Drinks"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pizza Pepperoni",
                description = "Classic pizza with pepperoni",
                imageUrl = "https://www.laespanolaaceites.com/wp-content/uploads/2019/06/pizza-con-chorizo-jamon-y-queso-1080x671.jpg"
            ),
            Dish(
                id = 2,
                name = "Pizza Vegetariana",
                description = "Classic pizza with veggies",
                imageUrl = "https://www.hola.com/horizon/landscape/e9e1e82cb873-pepperoni-pizza-abob-t.jpg"
            ),
            Dish(
                id = 3,
                name = "Cheese pizza",
                description = "Classic pizza with extra cheese",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0Lj3_8eh0xYQLDhyh1pYwOF6l00mL7hIfww&s"
            ),
            Dish(
                id = 4,
                name = "Meat pizza",
                description = "Classic pizza with meat",
                imageUrl = "https://www.thespruceeats.com/thmb/xuxwh4RIGcZMgaJE8u3SueM0SoA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/aqIMG_4568fhor-0b89dc5c8c494ee9828ed29805791c5a.jpg"
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger King Kong",
        description = "Big burgers",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Burger_King_2020.svg/1200px-Burger_King_2020.svg.png",
        categories = listOf("Fast food", "Desserts and sweets", "Drinks"),
        menu = listOf(
            Dish(
                id = 5,
                name = "Medium burger",
                description = "Medium burger",
                imageUrl = "https://simplehomeedit.com/wp-content/uploads/2024/03/Homemade-Beef-Burgers-4.webp"
            ),
            Dish(
                id = 6,
                name = "Big burger",
                description = "Big burger",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeoBUl2L5VugaXVCjkVdRtNi8p_PIttRImgw&s"
            ),
            Dish(
                id = 7,
                name = "Soda",
                description = "Big soda",
                imageUrl = "https://i5.walmartimages.com/seo/Coca-Cola-Soda-Pop-2-Liters-Bottle_276fc3fd-fb2b-4c06-a277-5960a7e56495.c49f20b917881d57ead19e24bbad7b23.jpeg"
            )
        )
    ),
    Restaurant(
        id = 3,
        name = "Boston",
        description = "Ice creams!",
        imageUrl = "https://www.plazamerliot.com.sv/wp-content/uploads/2019/11/boston.png",
        categories = listOf("Desserts and sweets", "Drinks"),
        menu = listOf(
            Dish(
                id = 8,
                name = "Vanilla ice cream",
                description = "Vanilla",
                imageUrl = "https://laurenslatest.com/wp-content/uploads/2020/08/vanilla-ice-cream-5-copy-500x375.jpg"
            ),
            Dish(
                id = 9,
                name = "Chocolate ice cream",
                description = "Chocolate",
                imageUrl = "https://www.cravethegood.com/wp-content/uploads/2021/04/sous-vide-chocolate-ice-cream-15.jpg"
            ),
            Dish(
                id = 10,
                name = "Strawberry ice cream",
                description = "Strawberry",
                imageUrl = "https://www.elmundoeats.com/wp-content/uploads/2024/07/Strawberry-ice-cream-in-a-cone.jpg"
            ),
            Dish(
                id = 11,
                name = "Cookies and cream ice cream",
                description = "Cookies and cream",
                imageUrl = "https://www.pbfingers.com/wp-content/uploads/2022/06/oreo-cheesecake-ice-cream-9.jpg"
            ),
            Dish(
                id = 12,
                name = "Lemon ice cream",
                description = "Lemon",
                imageUrl = "https://lh3.googleusercontent.com/w6rAPX2dDRxBpQfgRiCfKbtBqAeY8XWKX4XvS7whfxP2wg7DneECla0fTZYFq0zUcZ3beev4kjyApQeHvE9-zHASdUjdfp6lL7mgJbmAenpTwLnEOPg7=s1200-p"
            )
        )
    )
)
