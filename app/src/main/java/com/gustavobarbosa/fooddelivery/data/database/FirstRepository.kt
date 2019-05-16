package com.gustavobarbosa.fooddelivery.data.database

class FirstRepository(
    val localDataSource: FirstDataSource,
    val remoteDataSource: FirstDataSource
) : FirstDataSource