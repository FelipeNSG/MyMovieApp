package com.example.mymovieapp.screens.details

import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails

class DetailsController(
    private val model: DetailsModel
) {
    suspend fun getMovieDetails(id: Int, callback: (MovieAndSeriesDetails?) -> Unit) {
        val movieDetails = model.getMovieDetails(id)
        callback.invoke(movieDetails)
    }

    suspend fun getMovieCredits(id: Int, callback: (List<MovieCast>) -> Unit) {
        val movieCredits = model.getMovieCredits(id)
        callback.invoke(movieCredits)
    }

    suspend fun getMovieImagesPoster(id: Int, callback: (List<MovieAndSeriesImagePoster>) -> Unit) {
        val moviePosterImages = model.getMovieImagesPoster(id)
        callback.invoke(moviePosterImages)
    }

    suspend fun getSeriesDetails(id: Int, callback: (MovieAndSeriesDetails?) -> Unit) {
        val seriesDetails = model.getSeriesDetails(id)
        callback.invoke(seriesDetails)
    }

    suspend fun getSeriesCredits(id: Int, callback: (List<MovieCast>) -> Unit) {
        val seriesCredits = model.getSeriesCredits(id)
        callback.invoke(seriesCredits)
    }

    suspend fun getSeriesImagesPoster(id: Int, callback: (List<MovieAndSeriesImagePoster>) -> Unit) {
        val seriesPosterImages = model.getSeriesImagesPoster(id)
        callback.invoke(seriesPosterImages)
    }

}