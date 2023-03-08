package com.example.sg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.sg.Common.GetURL.BASE_URL
import com.example.sg.Model.DetailsProduct
import com.example.sg.Model.Product
import com.example.sg.Network.APIService
import com.example.sg.Network.Retrofit
import com.example.sg.databinding.ActivityDetailsProductBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class DetailsProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsProductBinding
    private val api : APIService by lazy {
        Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productId = intent.getIntExtra("id", 1)
        binding.apply {
            val callDetailsProductApi = api.getProductDetails(productId)
            callDetailsProductApi.enqueue(object : Callback<DetailsProduct>{
                override fun onResponse(
                    call: Call<DetailsProduct>,
                    response: Response<DetailsProduct>
                ) {
                    when(response.code()){
                        in 200..299 ->{

                            response.body().let {itBody ->

                                if (itBody != null) {
                                    Picasso.get().load(itBody.images[0]).into(itemImage)
                                    itemTitle.text = itBody.title
                                    itemDescription.text = itBody.description
                                    itemPrice.text = itBody.price.toString()
                                    itemDiscountPercentage.text = itBody.discountPercentage.toString()
                                    itemRating.text = itBody.rating.toString()
                                    itemStock.text = itBody.stock.toString()
                                    itemBrand.text = itBody.brand
                                    itemCategory.text = itBody.category

                                }


                            }

                        }
                        in 300..399 ->{
                            Log.d("Response Code", "Client error message : ${response.code()}")
                        }
                        in 400..499 ->{
                            Log.d("Response Code", "Client error message : ${response.code()}")
                        }
                        in 500..599 ->{
                            Log.d("Response Code", "Client error message : ${response.code()}")
                        }

                    }
                }

                override fun onFailure(call: Call<DetailsProduct>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}