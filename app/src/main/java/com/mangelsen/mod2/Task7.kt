package com.mangelsen.mod2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mangelsen.mod2.ui.theme.Mod2Theme

data class Contact(
    val name: String,
    val surname: String,
    val familyName: String,
    val phone: String?,
    val address: String
)

val contacts = listOf(
    Contact("Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12"),
    Contact("Василий", "Егорович", "Кузякин", null, "Ивановская область, дер. Крутово, д. 4"),
    Contact("Людмила", "Прокофьевна", "Калугина", "+7 495 788 78 78", "Москва, Большая Никитская, д. 43, кв. 290")
)

// 1) Простой список полей контакта
@Composable
fun ContactColumn(contact: Contact) {
    Column {
        Text(text = "Имя: ${contact.name}")
        Text(text = "Отчество: ${contact.surname}")
        Text(text = "Фамилия: ${contact.familyName}")
        Text(text = "Мобильный телефон: ${contact.phone ?: "---"}")
        Text(text = "Адрес: ${contact.address}")
    }
}

// 2) Карточка контакта: серый фон, текст по центру
@Composable
fun ContactCard(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Имя: ${contact.name}")
        Text(text = "Отчество: ${contact.surname}")
        Text(text = "Фамилия: ${contact.familyName}")
        Text(text = "Мобильный телефон: ${contact.phone ?: " ---"}")
        Text(text = "Адрес: ${contact.address}", textAlign = TextAlign.Center)
    }
}

@Composable
fun ContactList(list: List<Contact>) {
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        for (contact in list) {
            ContactCard(contact)
        }
    }
}

// 3) Строка: данные контакта слева, картинка справа
@Composable
fun ContactRow(contact: Contact) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Имя: ${contact.name}")
            Text(text = "Отчество: ${contact.surname}")
            Text(text = "Фамилия: ${contact.familyName}")
            Text(text = "Мобильный телефон: ${contact.phone ?: "---"}")
            Text(text = "Адрес: ${contact.address}", modifier = Modifier.fillMaxWidth())
        }
        Image(
            painter = painterResource(R.drawable.star),
            contentDescription = "Избранное",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(name = "ContactColumnPreview", showSystemUi = true)
@Composable
fun ContactColumnPreview() {
    Mod2Theme {
        // отступ сверху: в превью строка состояния рисуется поверх контента
        Box(modifier = Modifier.padding(top = 32.dp)) {
            ContactColumn(contacts[0])
        }
    }
}

@Preview(name = "ListPreview", showSystemUi = true)
@Composable
fun ListPreview() {
    Mod2Theme {
        // отступ сверху: в превью строка состояния рисуется поверх контента
        Box(modifier = Modifier.padding(top = 32.dp)) {
            ContactList(contacts)
        }
    }
}

@Preview(name = "ContactRowPreview", showSystemUi = true)
@Composable
fun ContactRowPreview() {
    Mod2Theme {
        // отступ сверху: в превью строка состояния рисуется поверх контента
        Box(modifier = Modifier.padding(top = 32.dp)) {
            ContactRow(contacts[0])
        }
    }
}
