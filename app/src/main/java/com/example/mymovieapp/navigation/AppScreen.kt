package com.example.mymovieapp.navigation

sealed class AppScreen (val route: String){
    object  Home:AppScreen("Home")
    object  MovieDetails:AppScreen("MovieDetails")
}
