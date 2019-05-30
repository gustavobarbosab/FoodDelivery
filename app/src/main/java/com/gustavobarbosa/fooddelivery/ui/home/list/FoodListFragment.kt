package com.gustavobarbosa.fooddelivery.ui.home.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gustavobarbosa.fooddelivery.R
import kotlinx.android.synthetic.main.fragment_food_list.*

class FoodListFragment: Fragment() {

    private val foodSelectedListFragment = object :FoodAdapter.ClickAddFoodListener {
        override fun onFoodChoose(foodName: String) {
            Toast.makeText(context,foodName,Toast.LENGTH_SHORT).show()
        }
    }

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
        rvFood.adapter = FoodAdapter(foodSelectedListFragment)
        rvFood.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
    }
}