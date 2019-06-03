package com.gustavobarbosa.fooddelivery.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.NumberFormat

@Parcelize
data class FoodModel(
    val name: String,
    val price: Float,
    val description: String
) : Parcelable {
    val priceFormatted: String
        get() = NumberFormat.getCurrencyInstance().format(price)
}