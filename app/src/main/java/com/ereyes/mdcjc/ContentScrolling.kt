package com.ereyes.mdcjc

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
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

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
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
                var urlValue by remember { mutableStateOf("") }
                /*Image(
                    painter = painterResource(id = R.drawable.ic_shop),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.card_imf_cover_heigth))
                        .background(colorResource(id = R.color.teal_200))
                )*/
                GlideImage(
                    model = urlValue, 
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.card_imf_cover_heigth))
                        .background(colorResource(id = R.color.teal_200)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id = R.string.card_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.common_margin_default)),
                    style = MaterialTheme.typography.h5
                )
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
                    singleLine = true,
                    trailingIcon = {
                        if(urlValue.isNotEmpty())
                        {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = null,
                                modifier = Modifier.clickable { urlValue = "" }
                            )
                        }
                    }
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
                var passwordValue by remember{ mutableStateOf("") }
                var isCheckBoxChecked by remember { mutableStateOf(false) }
                var isPasswordVisibility by remember { mutableStateOf(false) }
                OutlinedTextField(
                    value = passwordValue,
                    onValueChange = { password -> passwordValue = password},
                    label = {
                        Text(text = stringResource(id = R.string.card_password))
                    },
                    singleLine = true,
                    enabled = isCheckBoxChecked,
                    visualTransformation =
                        if(isPasswordVisibility)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.common_margin_default),
                            start = dimensionResource(id = R.dimen.common_margin_default),
                            end = dimensionResource(id = R.dimen.common_margin_default)
                        ),
                    trailingIcon = {
                        Icon(
                            painter =
                                if (isPasswordVisibility) 
                                    painterResource(id = R.drawable.ic_visibility_off)
                                else
                                    painterResource(id = R.drawable.ic_visibility),
                            contentDescription = null,
                            modifier = Modifier.clickable { isPasswordVisibility = !isPasswordVisibility }
                        )
                    }
                )
                Row (verticalAlignment = Alignment.CenterVertically){
                    Checkbox(
                        checked = isCheckBoxChecked, 
                        onCheckedChange = {isChecked -> isCheckBoxChecked = isChecked}
                    )
                    Text(text = stringResource(id = R.string.card_enable_password))
                    Spacer(modifier = Modifier.weight(1f, true))
                    Text(text = stringResource(id = R.string.hide_fab))
                    var isSwitchChecked by remember { mutableStateOf(false) }
                    Switch(
                        checked = isSwitchChecked,
                        onCheckedChange = { checked -> isSwitchChecked = checked },
                        modifier = Modifier
                            .padding(
                                end = dimensionResource(id = R.dimen.common_margin_default)
                            )
                    )
                }
                var sliderValue by remember { mutableStateOf(6f) }
                var textValue by remember { mutableStateOf("") }
                var context = LocalContext.current
                Text(
                    text = textValue,
                    modifier = Modifier.
                        padding(
                            start = dimensionResource(id = R.dimen.common_padding_default)
                        )
                )
                Slider(
                    value = sliderValue,
                    onValueChange = {
                        value -> sliderValue = value
                        textValue = "Val: ${value.toInt()}"
                    },
                    onValueChangeFinished = {
                        Toast.makeText(context, textValue, Toast.LENGTH_LONG).show()
                    },
                    valueRange = 0f..10f,
                    steps = 8
                )
                val emailValue by remember{ mutableStateOf("ereyes@gmail.com") }
                var cbVisible by remember{ mutableStateOf(true) }
                if(cbVisible){
                    Chip(
                        onClick = {
                            Toast.makeText(context, emailValue, Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.common_padding_default)
                            )
                    ) {
                        Text(text = emailValue)
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = null,
                            modifier = Modifier
                                .size(dimensionResource(id = R.dimen.common_padding_default))
                                .clickable { cbVisible = false }
                        )
                    }
                }
            }
        }
    }
}