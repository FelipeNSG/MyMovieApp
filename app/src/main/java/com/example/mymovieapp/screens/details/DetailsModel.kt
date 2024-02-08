package com.example.mymovieapp.screens.details

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails

class DetailsModel {
    private val repository = MoviesRepository
    suspend fun getMovieDetails(id:Int): MovieAndSeriesDetails? {
        return repository.getMovieDetails(id)
    }

    suspend fun getMovieCredits(id: Int): List<MovieCast> {
        return repository.getMovieCredits(id)
    }

    suspend fun getMovieImagesPoster(id:Int): List<MovieAndSeriesImagePoster> {
        return repository.getMovieImagesPoster(id)
    }

    suspend fun getSeriesDetails(id:Int): MovieAndSeriesDetails? {
        return repository.getSeriesDetails(id)
    }

    suspend fun getSeriesCredits(id: Int): List<MovieCast> {
        return repository.getSeriesCredits(id)
    }

    suspend fun getSeriesImagesPoster(id:Int): List<MovieAndSeriesImagePoster> {
        return repository.getSeriesImagesPoster(id)
    }


}