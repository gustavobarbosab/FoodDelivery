package com.gustavobarbosa.fooddelivery.data.network.datasource

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodDataSource

class RemoteFoodDataSource: FoodDataSource {
    override fun getFoodCart(): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveFoodOnCart(food: String) {

    }

    override fun removeFoodOfCart(food: String) {
    }
}