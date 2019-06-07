package com.gustavobarbosa.fooddelivery.data.repository.food

import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import io.reactivex.Single

interface FoodDataSource {
    fun saveFoodOnCart(food: FoodModel): Single<ArrayList<FoodModel>>
    fun removeFoodOfCart(food: FoodModel): Single<ArrayList<FoodModel>>
    fun getFoodCart(): Single<ArrayList<FoodModel>>
}