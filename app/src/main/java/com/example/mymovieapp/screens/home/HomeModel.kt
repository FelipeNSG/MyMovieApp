package com.example.mymovieapp.screens.home

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.Series

class HomeModel {

    private val repository = MoviesRepository
    suspend fun getPopularMovies(): List<Movie> {
        return repository.getPopularMovies()
    }

    suspend fun getPlayNowMovies(): List<Movie> {
        return repository.getPlayNow()
    }

    suspend fun getUpcomingMovies(): List<Movie> {
        return repository.getUpcomingMovies()
    }

    suspend fun getTopRate(): List<Movie> {
        return repository.getTopRate()
    }

    suspend fun getPopularSeries(): List<Series> {
        return repository.getPopularSeries()
    }

}