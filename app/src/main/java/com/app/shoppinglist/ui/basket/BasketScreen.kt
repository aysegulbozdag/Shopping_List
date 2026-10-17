package com.app.shoppinglist.ui.basket

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

@Composable
fun BasketScreen(
    modifier: Modifier = Modifier,
    totalAmount: String?
) {
    Column(modifier = modifier) {
        Text(text = "Toplam tutar: $totalAmount")
    }
}


//init bloğu sayfa açıldığında çalışır ancak sayfa açıldığında logalama veya ekstra bir işlem yapılmayacaksa yazılmasına gerekt yoktur.
// Eğer yazılmazsa boş bir init gibi davranır.

//Aşağıdaki kullanım, navigation pass value için best practice olarak kullanılmaktadır. Eğer bir viewmodel varsa kullanılabilir.
class BasketViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val total = savedStateHandle.get<String>("totalAmount")

}