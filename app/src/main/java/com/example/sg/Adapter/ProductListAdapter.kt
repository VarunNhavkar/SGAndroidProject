package com.example.sg.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sg.DetailsProductActivity
import com.example.sg.DetailsProductFragment
import com.example.sg.Model.Product
import com.example.sg.R
import com.example.sg.databinding.LayoutProductListBinding
import com.squareup.picasso.Picasso

class ProductListAdapter(var context: Context,var productModelList: List<Product>):
RecyclerView.Adapter<ProductListAdapter.MyViewModel>(){

    lateinit var binding: LayoutProductListBinding



    inner class MyViewModel(val binding: LayoutProductListBinding):RecyclerView.ViewHolder(binding.root) {


        init {


            itemView.setOnClickListener {
                val intent = Intent(context, DetailsProductActivity::class.java)
                intent.putExtra("id", itemView.id)
                context.startActivity(intent )
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val binding = LayoutProductListBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewModel(binding)  }

    override fun getItemCount(): Int {
        return productModelList.size
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        val product = productModelList[position]
        with(holder.binding){
            Picasso.get().load(product.images[0]).into(imageview)
            productTitle.text=product.title
            productDescription.text=product.description
            productBrand.text=product.brand}
    }

}