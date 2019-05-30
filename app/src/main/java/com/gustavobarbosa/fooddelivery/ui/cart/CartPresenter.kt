package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository

class CartPresenter(var view: CartContract.View?, private val foodRepository: FoodRepository): CartContract.Presenter {

    var list = foodRepository.getFoodCart()

    override fun reloadCart() {
        list = foodRepository.getFoodCart()
        view?.reloadCart(list)
    }

    fun destroy() {
        view = null
    }
}