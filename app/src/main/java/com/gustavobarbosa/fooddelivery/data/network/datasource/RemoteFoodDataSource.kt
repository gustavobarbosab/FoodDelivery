package com.gustavobarbosa.fooddelivery.data.network.datasource

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodDataSource
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

class RemoteFoodDataSource: FoodDataSource {
    override fun getFoodCart(): ArrayList<FoodModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveFoodOnCart(food: FoodModel) {

    }

    override fun removeFoodOfCart(food: FoodModel): ArrayList<FoodModel> {
        return arrayListOf()
    }
}