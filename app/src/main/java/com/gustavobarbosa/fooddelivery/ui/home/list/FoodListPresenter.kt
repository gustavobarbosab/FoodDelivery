package com.gustavobarbosa.fooddelivery.ui.home.list

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository

class FoodListPresenter(private val foodRepository: FoodRepository): FoodAdapter.ClickAddFoodListener {

    override fun onFoodChoose(foodName: String) {
        foodRepository.saveFoodOnCart(foodName)
    }
}