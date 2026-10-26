package com.mangelsen.mod2

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mangelsen.mod2.ui.theme.Mod2Theme

// Вариант 1: зелёный, 16.sp, курсив, по центру
@Preview(showBackground = true)
@Composable
fun TextPreview1() {
    Mod2Theme {
        Text(
            text = stringResource(R.string.jetpack_compose),
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
    }
}

// Вариант 2: одна строка, в конце многоточие
@Preview(showBackground = true)
@Composable
fun TextPreview2() {
    Mod2Theme {
        Text(
            text = stringResource(R.string.jetpack_compose),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

// Вариант 3: отступ первой строки 48.sp, 24.sp, чёрный текст, зелёный фон, подчёркнут
@Preview(showBackground = true)
@Composable
fun TextPreview3() {
    Mod2Theme {
        Text(
            text = stringResource(R.string.jetpack_compose),
            style = TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
            fontSize = 24.sp,
            color = Color.Black,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.background(Color.Green)
        )
    }
}
