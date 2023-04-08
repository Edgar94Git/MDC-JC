package com.ereyes.mdcjc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ereyes.mdcjc.ui.theme.MDCJCTheme

/****
 * Project: MDC JC
 * From: com.ereyes.mdcjc
 * Created by Edgar Reyes Gonzalez on 4/8/2023 at 11:06 AM
 * All rights reserved 2023.
 ****/
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentPreview() {
    MDCJCTheme {
        Content()
    }
}

@Composable
fun Content() {
    Text(
        text = "Hello word!",
        modifier = Modifier.fillMaxSize().background(Color.Cyan)
    )
}