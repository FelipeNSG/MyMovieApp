package com.example.mymovieapp.screens.details

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import com.example.mymovieapp.network.model.movieandseriescredit.MovieAndSeriesCredits
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InteractionImpl : DetailsContract.Model {
    private val moviesRepository: MoviesRepository = MoviesRepository
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun fetchMovieAndSeriesDetails(id: Int, type:String, result: (MovieAndSeriesDetails) -> Unit) {

        scope.launch {
            if (type == "movie"){
                val movieDetails = moviesRepository.getMovieDetails(id)
                result.invoke(movieDetails!!)
            }else {
                val seriesDetails = moviesRepository.getSeriesDetails(id)
                result.invoke(seriesDetails!!)
            }

        }

    }

    override fun fetchMovieCredits(id:Int,type:String,result: List<MovieAndSeriesCredits>) {

    }

    override fun fetchImagesPoster(id:Int,type:String, result: List<MovieAndSeriesImagePoster>) {

    }
}