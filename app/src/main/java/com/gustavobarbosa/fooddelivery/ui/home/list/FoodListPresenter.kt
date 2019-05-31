package com.gustavobarbosa.fooddelivery.ui.home.list

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

class FoodListPresenter(private val foodRepository: FoodRepository): FoodAdapter.ClickAddFoodListener {

    override fun onFoodChoose(food: FoodModel) {
        foodRepository.saveFoodOnCart(food)
    }
}