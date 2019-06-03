package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

interface CartContract {

    interface View {
        fun reloadCart(foods: List<FoodModel>)
        fun showButtonNext()
        fun hideButtonNext()
    }

    interface Presenter {
        fun reloadCart()
        fun destroy()
    }
}