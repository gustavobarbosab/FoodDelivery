package com.gustavobarbosa.fooddelivery.data.repository.food

import com.gustavobarbosa.fooddelivery.data.repository.ResponseListener
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

interface FoodDataSource {
    fun saveFoodOnCart(food: FoodModel, listener: ResponseListener<ArrayList<FoodModel>>)
    fun removeFoodOfCart(food: FoodModel, listener: ResponseListener<ArrayList<FoodModel>>)
    fun getFoodCart(listener: ResponseListener<ArrayList<FoodModel>>)
}