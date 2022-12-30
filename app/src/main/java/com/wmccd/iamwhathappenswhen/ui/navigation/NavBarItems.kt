package com.wmccd.iamwhathappenswhen.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object NavBarItems {
    val Items = listOf(
        NavBarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = NavRoutes.Home.route
        ),
        NavBarItem(
            title = "Music",
            image = Icons.Filled.PlayArrow,
            route = NavRoutes.Listen.route
        ),
        NavBarItem(
            title = "Read",
            image = Icons.Filled.Info,
            route = NavRoutes.Read.route
        ),
        NavBarItem(
            title = "Think",
            image = Icons.Filled.Face,
            route = NavRoutes.Think.route
        )
    )
}