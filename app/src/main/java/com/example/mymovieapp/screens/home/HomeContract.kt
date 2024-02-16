package com.example.mymovieapp.screens.home

import com.example.mymovieapp.movies.Movie

interface HomeContract {

    interface View {
        fun displayUpcomingMovies(movies: List<Movie>)
        fun displayMostPopularMovies(movies: List<Movie>)
        fun displayTopRateMovies(movies: List<Movie>)
        fun getSearchQuery(): String
    }

    interface Presenter {

        fun setView(view :View)
        fun getUpcomingMovies()
        fun getMostPopularMovies()
        fun getTopRateMovies()
    }
    interface Model {
        fun fetchUpcomingMovies()
        fun fetchMostPopularMovies(result: (List<Movie>) -> Unit)
        fun fetchTopRateMovies()
    }

}