package com.example.mymovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mymovieapp.screens.MediaScreen
import com.example.mymovieapp.screens.MovieDetails


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.Home.route) {
        composable(AppScreen.Home.route) {
            MediaScreen(navController = navController)
        }

        composable(
            AppScreen.MovieDetails.route + "/{title}",
            arguments = listOf(
                navArgument(name = "title") {
                type = NavType.StringType
                })
        ) {
            MovieDetails(navController = navController, it.arguments?.getString("title"))
        }
    }
}
