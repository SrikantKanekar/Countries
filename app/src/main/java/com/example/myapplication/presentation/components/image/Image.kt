package com.example.myapplication.presentation.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun MyCircularImage(
    modifier: Modifier = Modifier,
    imageVector: ImageVector
) {
    Card(
        modifier = modifier.requiredSize(80.dp),
        shape = CircleShape,
        elevation = 8.dp
    ) {
        MyImage(
            modifier = Modifier.fillMaxSize(),
            imageVector = imageVector,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun MyImage(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentScale: ContentScale = ContentScale.Fit
) {
    Image(
        modifier = modifier,
        imageVector = imageVector,
        contentScale = contentScale,
        contentDescription = ""
    )
}