package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

interface CartContract {

    interface View {
        fun reloadCart(foods: List<FoodModel>)
        fun showButtonNext()
        fun hideButtonNext()
        fun updatePrice(price: Double)
    }

    interface Presenter: CartAdapter.OnClickItem {
        fun reloadCart()
        fun destroy()
    }
}