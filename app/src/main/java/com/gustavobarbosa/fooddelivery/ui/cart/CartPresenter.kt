package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import java.text.NumberFormat

class CartPresenter(
    var view: CartContract.View?,
    private val foodRepository: FoodRepository
) : CartContract.Presenter {

    var list: ArrayList<FoodModel>? = foodRepository.getFoodCart()

    override fun removeItem(food: FoodModel) {
        list = foodRepository.removeFoodOfCart(food)
        updateView()
    }

    override fun reloadCart() {
        list = foodRepository.getFoodCart()
        updateView()
    }

    private fun updateView() {
        list?.let {
            if (it.isEmpty()) {
                hideViewsWithEmptyCart()
            } else {
                showViews(it)
            }
        }
    }

    private fun showViews(list: ArrayList<FoodModel>) {
        view?.updatePrice(getTotalPrice())
        view?.reloadCart(list)
        view?.showButtonNext()
    }

    private fun hideViewsWithEmptyCart() {
        view?.hideTotalPriceView()
        view?.hideButtonNext()
    }

    private fun getTotalPrice(): String {
        var sum = 0.0

        list?.forEach {
            sum = it.price.plus(sum)
        }

        return getPriceFormatted(sum)
    }

    private fun getPriceFormatted(value: Double) = NumberFormat.getCurrencyInstance().format(value)

    override fun destroy() {
        view = null
    }
}