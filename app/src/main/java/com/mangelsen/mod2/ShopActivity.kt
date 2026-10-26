package com.mangelsen.mod2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mangelsen.mod2.ui.theme.Mod2Theme
import kotlin.random.Random

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

class ShopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mod2Theme {
                ShoppingCartScreen()
            }
        }
    }

    @Composable
    fun ShoppingCartScreen() {
        var products by remember {
            mutableStateOf(
                listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        }
        // Сумма и количество считаются из списка заново, а не накапливаются
        val totalSum = products.sumOf { it.price }
        val productSize = products.size

        Column(modifier = Modifier.padding(top = 48.dp, start = 16.dp)) {
            for (product in products) {
                Text(text = product.name + " - " + product.price + " рублей")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Товаров на сумму: $totalSum рублей")
            AddProductSection(totalSum) {
                products = products + Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(0, 100)
                )
            }
            RemoveProductSection(productSize) {
                products = products.dropLast(1)
            }
        }
    }

    @Composable
    fun AddProductSection(
        totalSum: Int,
        onAdd: () -> Unit
    ) {
        val context = LocalContext.current
        // Если сумма заказа больше 500, то показываем сообщение о бесплатной доставке
        LaunchedEffect(totalSum) {
            if (totalSum > 500) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }
        Button(onClick = onAdd) {
            Text(text = "Добавить товар")
        }
    }

    @Composable
    fun RemoveProductSection(
        productSize: Int,
        onRemove: () -> Unit
    ) {
        if (productSize > 0) {
            Button(onClick = onRemove) {
                Text(text = "Удалить товар")
            }
        }
    }
}
