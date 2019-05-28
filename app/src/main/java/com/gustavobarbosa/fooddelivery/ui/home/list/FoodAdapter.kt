package com.gustavobarbosa.fooddelivery.ui.home.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gustavobarbosa.fooddelivery.R

class FoodAdapter: RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        //TOOD implementar isso
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food,parent,false)
        return ViewHolder(view)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}