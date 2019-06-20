package com.gustavobarbosa.fooddelivery.ui.home.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gustavobarbosa.fooddelivery.R
import com.gustavobarbosa.fooddelivery.data.database.datasource.LocalFoodDataSource
import com.gustavobarbosa.fooddelivery.data.network.datasource.RemoteFoodDataSource
import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import kotlinx.android.synthetic.main.fragment_food_list.rvFood

class FoodListFragment: Fragment() {

    //TODO isso será movido para o injector
    private val presenter = FoodListPresenter(FoodRepository(LocalFoodDataSource, RemoteFoodDataSource()))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        rvFood.adapter = FoodAdapter(presenter)
        rvFood.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
    }
}