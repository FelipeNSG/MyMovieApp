package com.example.mymovieapp.screens.home

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie

class HomeModel {

    private val repository = MoviesRepository
    suspend fun getPopularMovies(): List<Movie> {
        return repository.getPopularMovies()
    }

    suspend fun getPlayNowMovies(): List<Movie> {
       return repository.getPlayNow()
    }

}