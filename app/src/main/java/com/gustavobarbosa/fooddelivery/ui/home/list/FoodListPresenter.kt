package com.gustavobarbosa.fooddelivery.ui.home.list

import com.gustavobarbosa.fooddelivery.data.repository.ResponseListener
import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import com.gustavobarbosa.fooddelivery.domain.model.error.BaseError

class FoodListPresenter(private val foodRepository: FoodRepository): FoodAdapter.ClickAddFoodListener {

    override fun onFoodChoose(food: FoodModel) {
        foodRepository.saveFoodOnCart(food, object : ResponseListener<ArrayList<FoodModel>> {
            override fun onSuccess(response: ArrayList<FoodModel>) {
            }

            override fun onFailure(error: BaseError) {
            }
        })
    }
}