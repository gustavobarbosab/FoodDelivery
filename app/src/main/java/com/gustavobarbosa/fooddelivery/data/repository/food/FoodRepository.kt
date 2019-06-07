package com.gustavobarbosa.fooddelivery.data.repository.food

import com.gustavobarbosa.fooddelivery.data.network.datasource.RemoteFoodDataSource
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import io.reactivex.Single

class FoodRepository(
    private val localDataSource: FoodDataSource,
    private val remoteFoodDataSource: RemoteFoodDataSource
) : FoodDataSource {

    override fun saveFoodOnCart(food: FoodModel): Single<ArrayList<FoodModel>> = localDataSource.saveFoodOnCart(food)

    override fun removeFoodOfCart(food: FoodModel): Single<ArrayList<FoodModel>> =
        localDataSource.removeFoodOfCart(food)

    override fun getFoodCart(): Single<ArrayList<FoodModel>> = localDataSource.getFoodCart()

}