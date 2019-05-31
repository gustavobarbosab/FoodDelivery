package com.gustavobarbosa.fooddelivery.ui.home.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.gustavobarbosa.fooddelivery.R
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

class FoodAdapter(private val listener: ClickAddFoodListener) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    private val arrayFood: List<FoodModel> = listOf(
        FoodModel(name = "BBQ Burguer", price = 25.5F, description = "Cebola, hamburguer, pão de batata e batata rustica"),
        FoodModel(name = "Fit Burguer", price = 23.5F, description = "Cebola, hamburguer, pão de batata e batata rustica"),
        FoodModel(name = "Ring Burguer", price = 20.5F, description = "Cebola, hamburguer, pão de batata e batata rustica"),
        FoodModel(name = "Rustic Burguer", price = 29.7F, description = "Cebola, hamburguer, pão de batata e batata rustica")
    )

    override fun getItemCount(): Int = arrayFood.size

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrayFood[position]

        holder.tvFoodName.text = item.name
        holder.tvPrice.text = item.priceFormatted

        holder.btAddFood.setOnClickListener {
            listener.onFoodChoose(item)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val btAddFood: Button = view.findViewById(R.id.buttonAddFood)
        val tvFoodName: TextView = view.findViewById(R.id.tvItemFoodName)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    }

    interface ClickAddFoodListener {
        fun onFoodChoose(food: FoodModel)
    }
}