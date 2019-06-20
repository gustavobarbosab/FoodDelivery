package com.gustavobarbosa.fooddelivery.data.repository

import com.gustavobarbosa.fooddelivery.domain.model.error.BaseError

interface ResponseListener<T> {
    fun onSuccess(response: T)
    fun onFailure(error: BaseError)
}