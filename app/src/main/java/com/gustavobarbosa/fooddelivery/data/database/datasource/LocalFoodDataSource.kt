package com.gustavobarbosa.fooddelivery.data.database.datasource

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodDataSource
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

object LocalFoodDataSource : FoodDataSource{

    private val listFood: MutableList<FoodModel> = mutableListOf()

    override fun saveFoodOnCart(food: FoodModel) {
        listFood.add(food)
    }

    override fun removeFoodOfCart(food: FoodModel) {
        listFood.remove(food)
    }

    override fun getFoodCart() = listFood
}