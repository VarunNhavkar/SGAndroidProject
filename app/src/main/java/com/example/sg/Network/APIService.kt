package com.example.sg.Network

import com.example.sg.Model.ProductDTO
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("products")
    fun getItemList(): Call<ProductDTO>

}