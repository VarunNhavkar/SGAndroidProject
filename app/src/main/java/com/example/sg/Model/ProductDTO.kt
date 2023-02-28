package com.example.sg.Model

data class ProductDTO(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)