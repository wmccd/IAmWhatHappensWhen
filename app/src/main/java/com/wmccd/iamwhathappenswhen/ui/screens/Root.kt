package com.wmccd.iamwhathappenswhen.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.wmccd.iamwhathappenswhen.ui.navigation.BottomNavigationBar
import com.wmccd.iamwhathappenswhen.ui.navigation.NavigationHost

@Composable
fun Root() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Bottom Navigation")
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier.padding(paddingValues = padding)
            ){
                NavigationHost(navController = navController)
            }
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    )
}

@Preview
@Composable
private fun Preview() {
    Root()
}