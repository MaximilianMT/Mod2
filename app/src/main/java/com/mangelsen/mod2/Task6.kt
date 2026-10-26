package com.mangelsen.mod2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mangelsen.mod2.ui.theme.Mod2Theme

@Composable
fun CircleTopEnd() {
    Box(
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Круг",
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

@Composable
fun CircleStretched() {
    Box(
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Круг",
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}

@Preview(name = "CircleTopEnd", showSystemUi = true)
@Composable
fun CircleTopEndPreview() {
    Mod2Theme {
        // отступ сверху: в превью строка состояния рисуется поверх контента
        Box(modifier = Modifier.padding(top = 32.dp)) {
            CircleTopEnd()
        }
    }
}

@Preview(name = "CircleStretched", showSystemUi = true)
@Composable
fun CircleStretchedPreview() {
    Mod2Theme {
        // отступ сверху: в превью строка состояния рисуется поверх контента
        Box(modifier = Modifier.padding(top = 32.dp)) {
            CircleStretched()
        }
    }
}
