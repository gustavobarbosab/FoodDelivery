package com.gustavobarbosa.fooddelivery.ui.cart

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gustavobarbosa.fooddelivery.R
import com.gustavobarbosa.fooddelivery.data.database.datasource.LocalFoodDataSource
import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository

class CartFragment : Fragment(), CartContract.View {

    private val presenter = CartPresenter(this,FoodRepository(LocalFoodDataSource))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.reloadCart()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun reloadCart(foods: List<String>) {
        Toast.makeText(context,foods.lastOrNull(),Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = CartFragment()
    }
}