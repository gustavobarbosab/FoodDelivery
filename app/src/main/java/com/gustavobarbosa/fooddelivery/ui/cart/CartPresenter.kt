package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.data.repository.ResponseListener
import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import com.gustavobarbosa.fooddelivery.domain.model.error.BaseError
import java.text.NumberFormat

class CartPresenter(
    var view: CartContract.View?,
    private val foodRepository: FoodRepository
) : CartContract.Presenter {

    var list: ArrayList<FoodModel> = arrayListOf()

    override fun removeItem(food: FoodModel) {
        foodRepository.removeFoodOfCart(food, object : ResponseListener<ArrayList<FoodModel>> {
            override fun onSuccess(response: ArrayList<FoodModel>) {
                this@CartPresenter.list = response
                updateView()
            }

            override fun onFailure(error: BaseError) {
                view?.onError(error.cause)
            }
        })
    }

    override fun reloadCart() {
        foodRepository.getFoodCart(object : ResponseListener<ArrayList<FoodModel>> {
            override fun onSuccess(response: ArrayList<FoodModel>) {
                this@CartPresenter.list = response
                updateView()
            }

            override fun onFailure(error: BaseError) {
                this@CartPresenter.list.clear()
                hideViewsWithEmptyCart()
                view?.onError(error.cause)
            }
        })
    }

    private fun updateView() {
        if (list.isEmpty()) {
            hideViewsWithEmptyCart()
        } else {
            showViews(list)
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

        list.forEach {
            sum = it.price.plus(sum)
        }

        return getPriceFormatted(sum)
    }

    private fun getPriceFormatted(value: Double) = NumberFormat.getCurrencyInstance().format(value)

    override fun destroy() {
        view = null
    }
}