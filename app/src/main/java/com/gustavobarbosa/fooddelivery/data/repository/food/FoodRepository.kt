package com.gustavobarbosa.fooddelivery.data.repository.food

import com.gustavobarbosa.fooddelivery.data.network.datasource.RemoteFoodDataSource
import com.gustavobarbosa.fooddelivery.data.repository.ResponseListener
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

class FoodRepository(
    private val localDataSource: FoodDataSource,
    private val remoteFoodDataSource: RemoteFoodDataSource
) : FoodDataSource {

    override fun saveFoodOnCart(food: FoodModel, listener: ResponseListener<ArrayList<FoodModel>>) {
        localDataSource.saveFoodOnCart(food, listener)
    }

    override fun removeFoodOfCart(food: FoodModel, listener: ResponseListener<ArrayList<FoodModel>>) {
        localDataSource.removeFoodOfCart(food, listener)
    }

    override fun getFoodCart(listener: ResponseListener<ArrayList<FoodModel>>) {
        localDataSource.getFoodCart(listener)
    }
}