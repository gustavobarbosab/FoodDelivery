package com.gustavobarbosa.fooddelivery.domain.model

import java.text.NumberFormat

data class FoodModel(
    val name: String,
    val price: Float,
    val description: String
) {
    val priceFormatted
    get() = NumberFormat.getCurrencyInstance().format(price)
}