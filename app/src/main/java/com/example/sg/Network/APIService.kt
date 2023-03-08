package com.example.sg.Network

import com.example.sg.Model.DetailsProduct
import com.example.sg.Model.ProductDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("products")
    fun getItemList(): Call<ProductDTO>

    @GET("products/{product_id}")
    fun getProductDetails(@Path("product_id") id: Int): Call<DetailsProduct>

}