package com.gustavobarbosa.fooddelivery.data.repository.food

import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

interface FoodDataSource {
    fun saveFoodOnCart(food: FoodModel)
    fun removeFoodOfCart(food: FoodModel): ArrayList<FoodModel>
    fun getFoodCart(): ArrayList<FoodModel>
}