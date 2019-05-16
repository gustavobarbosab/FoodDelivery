package com.gustavobarbosa.fooddelivery.data.network

import com.gustavobarbosa.fooddelivery.data.network.service.CartService
import com.gustavobarbosa.fooddelivery.data.network.service.PaymentService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfigImpl : NetworkConfig {

    private val retrofitClient = Retrofit
        .Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCartService() = retrofitClient.create(CartService::class.java)
    fun getPaymentService() = retrofitClient.create(PaymentService::class.java)

}
