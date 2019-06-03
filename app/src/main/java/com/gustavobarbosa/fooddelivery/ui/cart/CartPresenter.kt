package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository

class CartPresenter(var view: CartContract.View?,
                    private val foodRepository: FoodRepository): CartContract.Presenter {

    var list = foodRepository.getFoodCart()

    override fun reloadCart() {
        list = foodRepository.getFoodCart()
        if (list.isEmpty()) {
            view?.hideButtonNext()
        } else {
            view?.reloadCart(list)
            view?.showButtonNext()
        }
    }

    override fun destroy() {
        view = null
    }
}