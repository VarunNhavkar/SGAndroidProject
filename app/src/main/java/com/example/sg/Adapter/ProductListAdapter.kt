package com.example.sg.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sg.Model.Product
import com.example.sg.R
import com.squareup.picasso.Picasso

class ProductListAdapter(var context: Context,var productModelList: List<Product>):
RecyclerView.Adapter<ProductListAdapter.MyViewModel>(){
    inner class MyViewModel(itemView: View):RecyclerView.ViewHolder(itemView) {
        var imgItem: ImageView
        var txtTitle: TextView
        var txtDescription: TextView
        var txtBrand: TextView

        init {
            imgItem=itemView.findViewById(R.id.imageView)
            txtTitle=itemView.findViewById(R.id.productTitle)
            txtDescription=itemView.findViewById(R.id.productDescription)
            txtBrand=itemView.findViewById(R.id.productBrand)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.layout_product_list,parent,false))

    }

    override fun getItemCount(): Int {
        return productModelList.size
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        val product = productModelList[position]
        Picasso.get().load(product.images[0]).into(holder.imgItem)
        holder.txtTitle.text=product.title
        holder.txtDescription.text=product.description
        holder.txtBrand.text=product.brand
    }

}