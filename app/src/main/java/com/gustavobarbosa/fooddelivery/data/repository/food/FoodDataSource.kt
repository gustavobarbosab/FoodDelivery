package com.gustavobarbosa.fooddelivery.data.repository.food

interface FoodDataSource {
    fun saveFoodOnCart(food: String)
    fun removeFoodOfCart(food: String)
}