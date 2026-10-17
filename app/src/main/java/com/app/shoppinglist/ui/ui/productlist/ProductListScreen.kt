package com.app.shoppinglist.ui.ui.productlist

import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.shoppinglist.ui.ui.theme.ShoppingListTheme
import com.app.shoppinglist.ui.ui.totalAmount
import kotlinx.coroutines.launch

@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    onNavigateToBasket: (Double) -> Unit,
    viewModel: ProductListViewModel = viewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(
        modifier
            .fillMaxSize()
    ) {
        items(viewModel.productList) { productItem ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp) // Sistem barlarının boşluğunu otomatik uygular
                    .statusBarsPadding()
            ) {
                Text(
                    modifier = modifier.weight(2f),
                    text = "${productItem.name} ${productItem.price}"
                )
                Button(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {
                        coroutineScope.launch {
                            try {
                                viewModel.addToBasket(productItem)

                                Toast.makeText(
                                    context,
                                    "Sepete eklendi." + viewModel.totalAmount,
                                    Toast.LENGTH_SHORT
                                ).show()

                                onNavigateToBasket(viewModel.totalAmount)
                            } catch (e: Exception) {
                                Toast.makeText(
                                    context,
                                    "Hata Oluştu ${e.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }) {
                    Text(fontSize = 10.sp, text = "Sepete Ekle")
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductListScreenPreview() {
    ShoppingListTheme {
        ProductListScreen(onNavigateToBasket = {})
    }
}


