package com.gustavobarbosa.fooddelivery.ui.cart

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gustavobarbosa.fooddelivery.R
import com.gustavobarbosa.fooddelivery.data.database.datasource.LocalFoodDataSource
import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import kotlinx.android.synthetic.main.content_logo.view.primaryTitle
import kotlinx.android.synthetic.main.content_logo.view.secondaryTitle
import kotlinx.android.synthetic.main.fragment_cart.rvCart
import kotlinx.android.synthetic.main.fragment_cart.titleCart

class CartFragment : Fragment(), CartContract.View {

    private val presenter = CartPresenter(this,FoodRepository(LocalFoodDataSource))
    private val adapter = CartAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleCart.primaryTitle.text = "My"
        titleCart.secondaryTitle.text = "Orders"
        rvCart.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvCart.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.reloadCart()
    }

    override fun reloadCart(foods: List<String>) {
        adapter.arrayFood = foods
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    companion object {
        fun newInstance() = CartFragment()
    }
}