package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.text.NumberFormat

class CartPresenter(
    var view: CartContract.View?,
    private val foodRepository: FoodRepository,
    private val compositeDisposable: CompositeDisposable
) : CartContract.Presenter {

    var list: ArrayList<FoodModel> = arrayListOf()

    override fun removeItem(food: FoodModel) {
        compositeDisposable.add(
            foodRepository
                .removeFoodOfCart(food)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    this@CartPresenter.list = response
                    updateView()
                }, {
                    it.message?.let { message ->
                        view?.onError(message)
                    }
                })
        )
    }

    override fun reloadCart() {
        compositeDisposable.add(
            foodRepository
                .getFoodCart()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    this@CartPresenter.list = response
                    updateView()
                }, {
                    it.message?.let { message ->
                        hideViewsWithEmptyCart()
                        view?.onError(message)
                    }
                })
        )
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
        compositeDisposable.dispose()
        view = null
    }
}