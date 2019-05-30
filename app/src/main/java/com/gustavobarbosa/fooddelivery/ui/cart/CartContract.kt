package com.gustavobarbosa.fooddelivery.ui.cart

interface CartContract {

    interface View {
        fun reloadCart(foods: List<String>)
    }

    interface Presenter {
        fun reloadCart()
    }
}