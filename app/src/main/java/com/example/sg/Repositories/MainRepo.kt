package com.example.sg.Repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sg.Common.GetURL
import com.example.sg.Model.ProductDTO
import com.example.sg.Network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo {

    private val apiservice : APIService

    companion object{
        private const val TAG="MainRepo"
    }
    init {
        apiservice= GetURL.getAPIService
    }

    private val _getItemModelLiveData: MutableLiveData<ProductDTO?> = MutableLiveData<ProductDTO?>()
    val getItemModelLiveData: LiveData<ProductDTO?>
        get() = _getItemModelLiveData


    fun getProducts(){
//        val data: LiveData<ProductDTO?> = MutableLiveData<ProductDTO>()
        apiservice.getItemList().enqueue(object : Callback<ProductDTO> {


            override fun onResponse(call: Call<ProductDTO>, response: Response<ProductDTO>) =
                //Log.e(TAG,"onResponse: "+response.code())
                if(response.isSuccessful){
                    _getItemModelLiveData.value= response.body()
                }
                else{
                    _getItemModelLiveData.value=null
                }

            override fun onFailure(call: Call<ProductDTO>, t: Throwable) {
                Log.e("varun","onResponse: "+t.message)
                _getItemModelLiveData.value=null
            }
        })
    }


}