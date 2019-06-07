package com.gustavobarbosa.fooddelivery.data.database.datasource

import com.gustavobarbosa.fooddelivery.data.repository.ResponseListener
import com.gustavobarbosa.fooddelivery.data.repository.food.FoodDataSource
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

object LocalFoodDataSource : FoodDataSource{

    private val listFood: ArrayList<FoodModel> = arrayListOf()

    override fun saveFoodOnCart(food: FoodModel, listener: ResponseListener<ArrayList<FoodModel>>) {
        listFood.add(food)
        listener.onSuccess(listFood)
    }

    override fun removeFoodOfCart(food: FoodModel, listener: ResponseListener<ArrayList<FoodModel>>) {
        listFood.remove(food)
        listener.onSuccess(listFood)
    }

    override fun getFoodCart(listener: ResponseListener<ArrayList<FoodModel>>) {
        listener.onSuccess(listFood)
    }
}