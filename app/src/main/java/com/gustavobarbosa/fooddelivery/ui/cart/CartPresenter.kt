package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

class CartPresenter(
    var view: CartContract.View?,
    private val foodRepository: FoodRepository
) : CartContract.Presenter {

    var list: ArrayList<FoodModel>? = foodRepository.getFoodCart()

    override fun removeItem(food: FoodModel) {
        list = foodRepository.removeFoodOfCart(food)
        updateViewList()
    }

    override fun reloadCart() {
        list = foodRepository.getFoodCart()
        updateViewList()
    }

    private fun updateViewList() {
        list?.let {
            if (it.isEmpty()) {
                view?.hideButtonNext()
            } else {
                view?.reloadCart(it)
                view?.showButtonNext()
            }
        }
    }

    fun destroy() {
        view = null
    }
}