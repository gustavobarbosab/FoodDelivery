package com.gustavobarbosa.fooddelivery.ui.cart

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.gustavobarbosa.fooddelivery.R

class CartAdapter() : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    var arrayFood: List<String> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = arrayFood.size

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrayFood[position]

        holder.tvFoodName.text = item
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvFoodName: TextView = view.findViewById(R.id.tvItemFoodName)
    }
}