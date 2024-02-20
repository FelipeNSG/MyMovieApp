package com.example.mymovieapp.screens.details

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InteractionImpl : DetailsContract.Model {
    private val moviesRepository: MoviesRepository = MoviesRepository
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun fetchMovieAndSeriesDetails(
        id: Int,
        type: String,
        result: (Stated) -> Unit
    ) {

        scope.launch {
            if (type == "movie") {
                val movieDetails = moviesRepository.getMovieDetails(id)
                //TODO(AVOID TO USE !! OPERATOR IS NOT SAFE)
                if (movieDetails != null)
                    result.invoke(Stated.Success(movieDetails))
                else result.invoke(Stated.Loading)
            }
            else {
                val seriesDetails = moviesRepository.getSeriesDetails(id)
                //TODO(SAME AS ABOVE)
                if (seriesDetails != null)
                    result.invoke(Stated.Success(seriesDetails))
                else result.invoke(Stated.Loading)
            }
        }
    }

    override fun fetchMovieCredits(id: Int, type: String, result: (List<MovieCast>) -> Unit) {

        scope.launch {
            if (type == "movie") {
                val movieCredits = moviesRepository.getMovieCredits(id)
                result.invoke(movieCredits)
            } else {
                val seriesCredits = moviesRepository.getSeriesCredits(id)
                result.invoke(seriesCredits)
            }
        }
    }

    override fun fetchImagesPoster(
        id: Int,
        type: String,
        result: (List<MovieAndSeriesImagePoster>) -> Unit
    ) {

        scope.launch {
            if (type == "movie") {
                val movieCredits = moviesRepository.getMovieImagesPoster(id)
                result.invoke(movieCredits)
            } else {
                val seriesCredits = moviesRepository.getSeriesImagesPoster(id)
                result.invoke(seriesCredits)
            }
        }
    }

}

sealed class Stated() {
    object Loading : Stated()
    data class Success(val details: MovieAndSeriesDetails) : Stated()
}