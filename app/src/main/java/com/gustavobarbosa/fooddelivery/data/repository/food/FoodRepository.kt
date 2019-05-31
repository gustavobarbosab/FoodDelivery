package com.gustavobarbosa.fooddelivery.data.repository.food

import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

class FoodRepository(private val localDataSource: FoodDataSource) : FoodDataSource {

    override fun getFoodCart(): List<FoodModel> = localDataSource.getFoodCart()

    override fun saveFoodOnCart(food: FoodModel) {
        localDataSource.saveFoodOnCart(food)
    }

    override fun removeFoodOfCart(food: FoodModel) {
        localDataSource.removeFoodOfCart(food)
    }
}