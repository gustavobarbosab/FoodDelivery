package com.gustavobarbosa.fooddelivery.data.repository.food

class FoodRepository(private val localDataSource: FoodDataSource) : FoodDataSource {

    override fun getFoodCart(): List<String> = localDataSource.getFoodCart()

    override fun saveFoodOnCart(food: String) {
        localDataSource.saveFoodOnCart(food)
    }

    override fun removeFoodOfCart(food: String) {
        localDataSource.removeFoodOfCart(food)
    }
}