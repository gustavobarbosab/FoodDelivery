package com.gustavobarbosa.fooddelivery.data.network.datasource

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodDataSource
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import io.reactivex.Single

class RemoteFoodDataSource: FoodDataSource {
    override fun saveFoodOnCart(food: FoodModel): Single<ArrayList<FoodModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeFoodOfCart(food: FoodModel): Single<ArrayList<FoodModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFoodCart(): Single<ArrayList<FoodModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}