package com.pmtaller2.AlexanderMorales_00024123.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val restaurant: Restaurant,
    val dish: Dish,
    val creationDate: Long = System.currentTimeMillis()
)