package com.wmccd.iamwhathappenswhen.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wmccd.iamwhathappenswhen.ui.screens.Home
import com.wmccd.iamwhathappenswhen.ui.screens.Music
import com.wmccd.iamwhathappenswhen.ui.screens.Read
import com.wmccd.iamwhathappenswhen.ui.screens.Think


@Composable
fun NavigationHost(navController: NavHostController){

    NavHost(navController = navController, startDestination = NavRoutes.Home.route){
        composable(route = NavRoutes.Home.route){
            Home()
        }
        composable(route = NavRoutes.Listen.route){
            Music()
        }
        composable(route = NavRoutes.Read.route){
            Read()
        }
        composable(route = NavRoutes.Think.route){
            Think()
        }
    }
}