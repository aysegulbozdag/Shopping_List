package com.app.shoppinglist.data

data class ProductItem(
    val id: Int,
    val name: String,
    val price: Double,
    var quantity: Int = 0,// miktar
    val unit: ShoppingUnit, // adet, kg, paket vb.
    val isChecked: Boolean = false
)
