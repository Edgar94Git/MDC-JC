package com.ereyes.mdcjc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.ic_shop),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.card_imf_cover_heigth))
                        .background(colorResource(id = R.color.teal_200))
                )
                Text(
                    text = stringResource(id = R.string.card_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.common_margin_default)),
                    style = MaterialTheme.typography.h5
                )
                var urlValue by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = urlValue,
                    onValueChange = { text -> urlValue = text},
                    label = {
                        Text(text = stringResource(id = R.string.card_input_url))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.common_margin_default),
                            start = dimensionResource(id = R.dimen.common_margin_default),
                            end = dimensionResource(id = R.dimen.common_margin_default)
                        ),
                    singleLine = true
                )
                Text(
                    text = stringResource(id = R.string.card_required),
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.common_padding_max),
                        top = dimensionResource(id = R.dimen.common_margin_micro)
                    )
                )
            }
        }
    }
}