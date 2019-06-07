package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

interface CartContract {

    interface View {
        fun reloadCart(foods: List<FoodModel>)
        fun showButtonNext()
        fun hideButtonNext()
        fun updatePrice(price: String)
        fun hideTotalPriceView()
        fun onError(error: String)
    }

    interface Presenter: CartAdapter.OnClickItem {
        fun reloadCart()
        fun destroy()
    }
}