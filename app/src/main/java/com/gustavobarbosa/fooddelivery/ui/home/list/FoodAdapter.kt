package com.gustavobarbosa.fooddelivery.ui.home.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.gustavobarbosa.fooddelivery.R

class FoodAdapter(private val listener: ClickAddFoodListener) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    val arrayFood: List<String> = listOf("BBQ Burguer", "Cheedar Burguer", "Fit Burger")

    override fun getItemCount(): Int = arrayFood.size

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrayFood[position]

        holder.tvFoodName.text = item

        holder.btAddFood.setOnClickListener {
            listener.onFoodChoose(item)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val btAddFood: Button = view.findViewById(R.id.buttonAddFood)
        val tvFoodName: TextView = view.findViewById(R.id.tvItemFoodName)
    }

    interface ClickAddFoodListener {
        fun onFoodChoose(foodName: String)
    }
}