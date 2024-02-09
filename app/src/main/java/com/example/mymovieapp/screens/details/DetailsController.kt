package com.example.mymovieapp.screens.details

import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsController(
    private val model: DetailsModel
) {
    val scope = CoroutineScope(Dispatchers.Default)

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

    suspend fun getSeriesImagesPoster(
        id: Int, callback: (List<MovieAndSeriesImagePoster>) -> Unit
    ) {
        val seriesPosterImages = model.getSeriesImagesPoster(id)
        callback.invoke(seriesPosterImages)
    }

    fun validationMovieAndSeriesDetails(
        id: Int?,
        type: String?,
        callbackDetails: (MovieAndSeriesDetails?) -> Unit
    ) {
        scope.launch {
            if (id != null && type == "movie") {
                getMovieDetails(id) {
                    callbackDetails.invoke(it)
                }
            }
            if (id != null && type == "series") {
                getSeriesDetails(id) {
                    callbackDetails.invoke(it)
                }
            }
        }
    }

    fun validationMovieAndSeriesCredits(
        id: Int?,
        type: String?,
        callbackCredits: (List<MovieCast>) -> Unit
    ) {
        scope.launch {
            if (id != null && type == "movie") {
                getMovieCredits(id) { credits ->
                    callbackCredits.invoke(credits)
                }
            }
            if (id != null && type == "series") {
                getSeriesCredits(id) { credits ->
                    callbackCredits.invoke(credits)
                }

            }
        }
    }

    fun validationMovieAndSeriesImagePoster(
        id: Int?,
        type: String?,
        callbackImagePoster: (List<MovieAndSeriesImagePoster>) -> Unit
    ) {
        scope.launch {
            if (id != null && type == "movie") {
                getMovieImagesPoster(id) { images ->
                    callbackImagePoster.invoke(images)
                }
            }
            if (id != null && type == "series") {
                getSeriesImagesPoster(id) { images ->
                    callbackImagePoster.invoke(images)
                }
            }
        }
    }
}