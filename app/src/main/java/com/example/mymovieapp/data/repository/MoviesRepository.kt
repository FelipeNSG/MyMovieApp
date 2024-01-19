package com.example.mymovieapp.data.repository

import android.util.Log
import com.example.mymovieapp.network.Movie
import com.example.mymovieapp.network.client.MovieClient
import com.example.mymovieapp.network.toMovie
import retrofit2.HttpException

// Repository
object MoviesRepository {

    suspend fun getPopularMovies(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getPopularMovies()
            result.results?.map { it?.toMovie() }?.filterNotNull() ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getWorstMovies(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getPopularMovies()
            result.results?.map { it?.toMovie() }?.filterNotNull() ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

}