package com.wmccd.iamwhathappenswhen.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Music() {
    Box(
       modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Icon(
          imageVector = Icons.Filled.PlayArrow,
          contentDescription = "Music",
          tint = Color.Blue,
          modifier = Modifier.size(150.dp).align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    Music()
}