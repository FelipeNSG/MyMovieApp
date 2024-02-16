package com.example.mymovieapp.screens.home

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InteractionImpl : HomeContract.Model {

    private val moviesRepository: MoviesRepository = MoviesRepository
    private val scope = CoroutineScope(Dispatchers.IO)
    override fun fetchUpcomingMovies() {

    }

    override fun fetchMostPopularMovies(result: (List<Movie>) -> Unit) {
        scope.launch {
            val movies = moviesRepository.getPopularMovies()
            result.invoke(movies)
        }
    }

    override fun fetchTopRateMovies() {

    }
}