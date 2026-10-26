package com.mangelsen.mod2

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mangelsen.mod2.ui.theme.Mod2Theme

@Preview(name = "portrait", showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Preview(name = "landscape", showSystemUi = true, device = "spec:width=411dp,height=891dp,orientation=landscape")
@Preview(
    name = "round",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFF00,
    device = "spec:width=200dp,height=200dp,dpi=320,isRound=true"
)
@Composable
fun HelloPreview() {
    Mod2Theme {
        Hello(
            name = "Android",
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}