package com.gustavobarbosa.fooddelivery.ui.home.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.gustavobarbosa.fooddelivery.R
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel

class FoodAdapter(private val listener: ClickAddFoodListener) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    private val arrayFood: List<FoodModel> = listOf(
        FoodModel(
            name = "BBQ Burguer",
            price = 25.5,
            description = "Cebola, hamburguer, pão de batata e batata rustica",
            imageURL = "https://uploads.metropoles.com/wp-content/uploads/2016/05/20200152/Cheeseburger-Vegetariano-Madero-Creditos-Nilo-Biazzetto-840x561.jpg"
        ),
        FoodModel(
            name = "Fit Burguer",
            price = 23.5,
            description = "Cebola, hamburguer, pão de batata e batata rustica",
            imageURL = "https://portal.minervafoods.com/files/como_fazer_hamburguer_caseiro.jpg"
        ),
        FoodModel(
            name = "Ring Burguer",
            price = 20.5,
            description = "Cebola, hamburguer, pão de batata e batata rustica",
            imageURL = "https://panelinha-sitenovo.s3-sa-east-1.amazonaws.com/receita/1184122800000-Hamburguer-de-frango.jpg"
        )
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

        Glide
            .with(holder.view.context)
            .load(item.imageURL)
            .into(holder.ivFood)

        holder.btAddFood.setOnClickListener {
            listener.onFoodChoose(item)
        }
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val btAddFood: Button = view.findViewById(R.id.buttonAddFood)
        val tvFoodName: TextView = view.findViewById(R.id.tvItemFoodName)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        val ivFood: ImageView = view.findViewById(R.id.ivFood)
    }

    interface ClickAddFoodListener {
        fun onFoodChoose(food: FoodModel)
    }
}