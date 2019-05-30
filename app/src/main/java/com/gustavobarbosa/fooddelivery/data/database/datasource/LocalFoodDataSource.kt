package com.gustavobarbosa.fooddelivery.data.database.datasource

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodDataSource

object LocalFoodDataSource : FoodDataSource{

    private val listFood: MutableList<String> = mutableListOf()

    override fun saveFoodOnCart(food: String) {
        listFood.add(food)
    }

    override fun removeFoodOfCart(food: String) {
        listFood.remove(food)
    }

    override fun getFoodCart() = listFood
}