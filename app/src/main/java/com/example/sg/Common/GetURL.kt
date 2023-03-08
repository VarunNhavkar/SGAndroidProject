package com.example.sg.Common

import com.example.sg.Network.APIService
import com.example.sg.Network.Retrofit

object GetURL {
    const val BASE_URL="https://dummyjson.com/";
    val getAPIService: APIService
        get()= Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)

}