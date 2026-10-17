package com.app.shoppinglist.ui.ui.productlist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.app.shoppinglist.data.ProductItem
import com.app.shoppinglist.data.ShoppingUnit

class ProductListViewModel( savedStateHandle: SavedStateHandle) : ViewModel() {
    val productList = listOf(
        ProductItem(id = 1, name = "Elma", price = 2.0, quantity = 0, unit = ShoppingUnit.KG),
        ProductItem(id = 2, name = "Şeftali", price = 5.0, quantity = 0, unit = ShoppingUnit.KG),
        ProductItem(id = 3, name = "Muz", price = 5.0, quantity = 0, unit = ShoppingUnit.KG),
    )

    var basketList = mutableListOf<ProductItem>()
    private set
    var totalAmount = 0.0
        private set

    fun addToBasket(productItem: ProductItem) {
        if (basketList.contains(productItem)) {
            basketList[basketList.indexOf(productItem)].quantity++
        } else {
            productItem.quantity = 1
            basketList.add(productItem)
        }
        totalAmount = totalAmount(basketList)
    }

    fun totalAmount(basketList: List<ProductItem>): Double {
        var total = 0.0

        basketList.forEach {
            total += it.price * it.quantity
        }
        return total
    }
}