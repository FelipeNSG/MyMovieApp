package com.example.mymovieapp.data.repository

import android.util.Log
import com.example.mymovieapp.domain.mappers.toMovie
import com.example.mymovieapp.domain.mappers.toMovieDetails
import com.example.mymovieapp.domain.mappers.toSeries
import com.example.mymovieapp.domain.mappers.toSeriesDetails
import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.MovieDetails
import com.example.mymovieapp.movies.Series
import com.example.mymovieapp.movies.SeriesDetails
import com.example.mymovieapp.network.client.MovieClient
import retrofit2.HttpException

//TODO("Take a look at the repository pattern")
//TODO("Take a look at the mapper pattern")
//TODO("Take a look at the result pattern")

object MoviesRepository {

    suspend fun getPopularMovies(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getPopularMovies()
            result.results?.mapNotNull { it?.toMovie() }?.apply {
                Log.i("size", this.size.toString())
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getTopRate(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getTopRate()
            result.results?.mapNotNull { it?.toMovie() }?.apply {
                Log.i("size", this.size.toString())
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getPopularSeries(): List<Series> {
        return try {
            val result = MovieClient.createMoviesService().getPopularSeries()
            result.results?.mapNotNull { it?.toSeries() }?.apply {
                Log.i("size", this.size.toString())
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getUpcomingMovies(): List<Movie> {

        return try {
            val result = MovieClient.createMoviesService().getUpcomingMovies()
            result.results?.mapNotNull { it?.toMovie() }?.apply {
                Log.i("size", this.size.toString())
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getPlayNow(): List<Movie> {

        return try {
            val result = MovieClient.createMoviesService().getPlayNow()
            result.results?.mapNotNull { it?.toMovie() }?.apply {
                Log.i("size", this.size.toString())
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getMovieDetails(id: Int): MovieDetails? {
        return try {
            val result = MovieClient.createMoviesService().getMovieDetails(id)
            result.toMovieDetails()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            return null
        }
    }

    suspend fun getSeriesDetails(id: Int): SeriesDetails? {
        return try {
            val result = MovieClient.createMoviesService().getSeriesDetails(id)
            result.toSeriesDetails()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            return null
        }
    }
}