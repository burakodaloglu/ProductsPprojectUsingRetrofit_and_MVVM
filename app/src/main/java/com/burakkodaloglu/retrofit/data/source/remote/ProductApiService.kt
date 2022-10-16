package com.burakkodaloglu.retrofit.data.source.remote

import android.telecom.Call
import com.burakkodaloglu.retrofit.common.Constans.GET_PRODUCT
import com.burakkodaloglu.retrofit.common.Constans.SEARCH_PRODUCT
import com.burakkodaloglu.retrofit.data.model.Product
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductApiService {
    @GET(GET_PRODUCT)
    fun getProduct():retrofit2.Call<List<Product>?>

    @POST(SEARCH_PRODUCT)
    @FormUrlEncoded
    fun searchProduct(
        @Field("query") query: String
    ): retrofit2.Call<List<Product>>
}