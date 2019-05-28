package com.gustavobarbosa.fooddelivery.ui.home.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gustavobarbosa.fooddelivery.R
import kotlinx.android.synthetic.main.fragment_food_list.*

class FoodListFragment: Fragment() {

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
        rvFood.adapter = FoodAdapter()
        rvFood.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
    }
}