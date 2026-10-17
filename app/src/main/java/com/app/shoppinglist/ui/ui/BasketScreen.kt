package com.app.shoppinglist.ui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.app.shoppinglist.data.ProductItem

@Composable
fun BasketScreen(
    modifier: Modifier = Modifier,
    basketList: List<ProductItem> = emptyList(),
    totalAmount: String?
) {
    Column(modifier = modifier) {
        LazyColumn() {
            items(basketList) {
                Text("${it.quantity} ${it.unit.displayName} ${it.name} birim fiyatı ${it.price}")
            }
        }

        Text(text = "Toplam tutar: $totalAmount")
    }


}

fun totalAmount(basketList: List<ProductItem>): Double {
    var total = 0.0

    basketList.forEach {
        total += it.price * it.quantity
    }
    return total
}

//init bloğu sayfa açıldığında çalışır ancak sayfa açıldığında logalama veya ekstra bir işlem yapılmayacaksa yazılmasına gerekt yoktur.
// Eğer yazılmazsa boş bir init gibi davranır.

//Aşağıdaki kullanım, navigation pass value için best practice olarak kullanılmaktadır. Eğer bir viewmodel varsa kullanılabilir.
class BasketViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val total = savedStateHandle.get<String>("totalAmount")

}