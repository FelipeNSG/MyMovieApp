package com.example.mymovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mymovieapp.screens.details.MovieDetails
import com.example.mymovieapp.screens.home.HomeViewModel
import com.example.mymovieapp.screens.home.MediaScreen
@Composable
fun AppNavigation(homeViewModel: HomeViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.Home.route) {
        composable(AppScreen.Home.route) {
            MediaScreen(navController = navController, homeViewModel)
        }
        composable(
            AppScreen.MovieDetails.route + "/{id}/{type}",
            arguments = listOf(
                navArgument(name = "id") {
                type = NavType.IntType
                },
                navArgument(name = "type") {
                    type = NavType.StringType
                }
            )
        ) {
            MovieDetails(it.arguments?.getInt("id"), it.arguments?.getString("type")){
                navController.popBackStack()
            }
        }
    }
}
