package com.example.sg.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sg.Model.ProductDTO
import com.example.sg.Repositories.MainRepo

class ProductViewModel : ViewModel() {
    private val mainrepo : MainRepo
    val getItemList: LiveData<ProductDTO?>
        get()= mainrepo.getItemModelLiveData

    init {
        mainrepo = MainRepo()
        mainrepo.getProducts()
    }
}