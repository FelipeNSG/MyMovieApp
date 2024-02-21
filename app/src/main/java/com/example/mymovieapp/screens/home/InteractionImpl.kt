package com.example.mymovieapp.screens.home

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.Series
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InteractionImpl : HomeContract.Model {

    private val moviesRepository: MoviesRepository = MoviesRepository
    private val scope = CoroutineScope(Dispatchers.IO)


    override fun fetchUpcomingMovies(result: (List<Movie>) -> Unit) {
        scope.launch {
            val movies = moviesRepository.getUpcomingMovies().take(5)
            result.invoke(movies)
        }
    }

    override fun fetchMostPopularMovies(result: (List<Movie>) -> Unit) {
        scope.launch {
            val movies = moviesRepository.getPopularMovies()
            result.invoke(movies)
        }
    }

    override fun fetchPlayNowMovies(result: (List<Movie>) -> Unit) {
        scope.launch {
            val movies = moviesRepository.getPlayNow()
            result.invoke(movies)
        }
    }

    override fun fetchTopRateMovies(result: (List<Movie>) -> Unit) {
        scope.launch {
            val movies = moviesRepository.getTopRate()
            result.invoke(movies)
        }
    }

    override fun fetchMostPopularSeries( result: (List<Series>) -> Unit) {
        scope.launch {
            val series = moviesRepository.getPopularSeries()
            result.invoke(series)
        }
    }
}