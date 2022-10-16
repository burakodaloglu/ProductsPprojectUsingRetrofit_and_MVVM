package com.burakkodaloglu.retrofit.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.burakkodaloglu.retrofit.common.ApiUtils
import com.burakkodaloglu.retrofit.data.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {

    private val service = ApiUtils.productApiService

    val productList = MutableLiveData<List<Product>?>()

    fun getProducts() {
        service.getProduct().enqueue(object : retrofit2.Callback<List<Product>?> {
            override fun onResponse(
                call: Call<List<Product>?>,
                response: Response<List<Product>?>
            ) {
                if (response.body().isNullOrEmpty()) {
                    productList.value = null
                } else {
                    productList.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Product>?>, t: Throwable) {
                // Bir sıkıntı varsa veya internet yoksa ne yapılacak
                Log.d("Failure", t.message.orEmpty())
            }

        })
    }

    fun searchProduct(query: String) {

        service.searchProduct(query).enqueue(object : Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                if (response.body().isNullOrEmpty()) {
                    productList.value = null
                } else {
                    productList.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("Failure", t.message.orEmpty())
            }
        })
    }

}