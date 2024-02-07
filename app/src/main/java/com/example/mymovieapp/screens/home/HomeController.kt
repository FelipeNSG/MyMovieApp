package com.example.mymovieapp.screens.home

import com.example.mymovieapp.movies.Movie

class HomeController(
    private val model: HomeModel
) {
    suspend fun getPopularMovies(callback: (List<Movie>) -> Unit) {
        val movies = model.getPopularMovies()
        callback.invoke(movies)
    }

    suspend fun getPlayNowMovies(callback: (List<Movie>) -> Unit) {
        val movies = model.getPlayNowMovies()
        callback.invoke(movies)
    }

}