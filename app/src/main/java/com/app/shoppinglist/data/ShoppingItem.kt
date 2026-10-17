package com.app.shoppinglist.data

data class ShoppingItem(
    val id: Int,
    val name: String,
    val quantity: Double,// miktar
    val unit: ShoppingUnit, // adet, kg, paket vb.
    val isChecked: Boolean = false
)
