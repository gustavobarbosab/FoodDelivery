package com.gustavobarbosa.fooddelivery.data.database.datasource

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodDataSource
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import io.reactivex.Single

object LocalFoodDataSource : FoodDataSource {

    private val listFood: ArrayList<FoodModel> = arrayListOf()

    override fun saveFoodOnCart(food: FoodModel): Single<ArrayList<FoodModel>> {
        listFood.add(food)
        return Single.just(listFood)
    }

    override fun removeFoodOfCart(food: FoodModel): Single<ArrayList<FoodModel>> {
        listFood.remove(food)
        return Single.just(listFood)
    }

    override fun getFoodCart(): Single<ArrayList<FoodModel>> = Single.just(listFood)

}