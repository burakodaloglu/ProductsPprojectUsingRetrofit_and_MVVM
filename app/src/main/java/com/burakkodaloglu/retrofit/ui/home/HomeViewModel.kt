package com.burakkodaloglu.retrofit.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.burakkodaloglu.retrofit.data.ProductRepository
import com.burakkodaloglu.retrofit.data.model.Product

class HomeViewModel: ViewModel() {
    private val productRepository = ProductRepository()

    private var _productList= MutableLiveData<List<Product>?>()
    val productList:LiveData<List<Product>?>
    get()=_productList

    init {
        products()
    }
     fun products () {
        productRepository.getProducts()
        _productList=productRepository.productList
    }

    fun searchProduct(query: String) {
        productRepository.searchProduct(query)
        _productList = productRepository.productList
    }
}