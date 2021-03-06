package com.example.myapplication.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyFormTitle(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier.padding(top = 8.dp, bottom = 16.dp),
        text = text,
        fontSize = 25.sp,
        style = MaterialTheme.typography.body1
    )
}


@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        modifier = modifier,
        text = text,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DataText(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        modifier = modifier,
        text = text,
        fontSize = 12.sp,
        style = MaterialTheme.typography.body1
    )
}
