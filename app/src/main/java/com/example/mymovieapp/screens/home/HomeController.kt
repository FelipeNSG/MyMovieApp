package com.example.mymovieapp.screens.home

import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.Series

class HomeController(
    private val model: HomeModel
) {
    suspend fun getUpcomingMovies(callback: (List<Movie>) -> Unit) {
        val movies = model.getUpcomingMovies()
        callback.invoke(movies)
    }
    suspend fun getPopularMovies(callback: (List<Movie>) -> Unit) {
        val movies = model.getPopularMovies()
        callback.invoke(movies)
    }

    suspend fun getPlayNowMovies(callback: (List<Movie>) -> Unit) {
        val movies = model.getPlayNowMovies()
        callback.invoke(movies)
    }


    suspend fun getTopRate(callback: (List<Movie>) -> Unit) {
        val movies = model.getTopRate()
        callback.invoke(movies)
    }

    suspend fun getPopularSeries(callback: (List<Series>) -> Unit) {
        val series = model.getPopularSeries()
        callback.invoke(series)
    }
}