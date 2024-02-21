package com.example.mymovieapp.screens.home

import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.Series

interface HomeContract {

    interface View {
        fun displayUpcomingMovies(movies: List<Movie>)
        fun displayMostPopularMovies(movies: List<Movie>)
        fun displayPlayNowMovies(movies: List<Movie>)
        fun displayTopRateMovies(movies: List<Movie>)
        fun displayMostPopularSeries(series: List<Series>)
    }

    interface Presenter {
        fun getUpcomingMovies()
        fun getMostPopularMovies()
        fun getPlayNowMovies()
        fun getTopRateMovies()
        fun getMostPopularSeries()

    }
    interface Model {
        fun fetchUpcomingMovies(result: (List<Movie>) -> Unit)
        fun fetchMostPopularMovies(result: (List<Movie>) -> Unit)
        fun fetchPlayNowMovies(result: (List<Movie>) -> Unit)
        fun fetchTopRateMovies(result: (List<Movie>) -> Unit)
        fun fetchMostPopularSeries(result: (List<Series>) -> Unit)

    }

}