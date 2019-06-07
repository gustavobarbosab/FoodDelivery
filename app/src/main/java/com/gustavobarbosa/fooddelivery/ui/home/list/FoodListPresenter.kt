package com.gustavobarbosa.fooddelivery.ui.home.list

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FoodListPresenter(
    private val foodRepository: FoodRepository,
    private val compositeDisposable: CompositeDisposable
) : FoodAdapter.ClickAddFoodListener {

    override fun onFoodChoose(food: FoodModel) {
        compositeDisposable.add(
            foodRepository
                .saveFoodOnCart(food)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }
}