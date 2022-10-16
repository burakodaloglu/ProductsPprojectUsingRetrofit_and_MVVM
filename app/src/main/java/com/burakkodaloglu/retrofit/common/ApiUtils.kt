package com.burakkodaloglu.retrofit.common

import com.burakkodaloglu.retrofit.common.Constans.BASE_URL
import com.burakkodaloglu.retrofit.data.source.remote.ProductApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val productApiService : ProductApiService by lazy { retrofit.create(ProductApiService::class.java) }
    //val productApiService: ProductApiService by lazy { retrofit.create(ProductApiService::class.java) }
}