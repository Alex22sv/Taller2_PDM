package com.pmtaller2.AlexanderMorales_00024123.local

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.pmtaller2.AlexanderMorales_00024123.model.Order

class OrderViewModel : ViewModel() {
    private val _orders = mutableStateListOf<Order>()
    val orders: List<Order> = _orders
    fun addOrder(order: Order) {
        _orders.add(order)
    }

    fun removeOrder(order: Order) {
        _orders.remove(order)
    }

    fun clearOrders() {
        _orders.clear()
    }
}