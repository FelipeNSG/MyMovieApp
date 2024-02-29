package com.example.mymovieapp.data.repository

import com.example.mymovieapp.domain.mappers.toMovie
import com.example.mymovieapp.domain.mappers.toMovieAndSeriesCast
import com.example.mymovieapp.domain.mappers.toMovieAndSeriesImagePoster
import com.example.mymovieapp.domain.mappers.toMovieDetails
import com.example.mymovieapp.domain.mappers.toSeries
import com.example.mymovieapp.domain.mappers.toSeriesDetails
import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.Series
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import com.example.mymovieapp.network.client.MovieClient
import retrofit2.HttpException

//TODO("Take a look at the repository pattern")
//TODO("Take a look at the mapper pattern")
//TODO("Take a look at the result pattern")

object MoviesRepository {
    suspend fun getPopularMovies(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getPopularMovies()
            result.results?.mapNotNull {
                it?.toMovie()
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getTopRate(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getTopRate()
            result.results?.mapNotNull {
                it?.toMovie()
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getPopularSeries(): List<Series> {
        return try {
            val result = MovieClient.createMoviesService().getPopularSeries()
            result.results?.mapNotNull {
                it?.toSeries()
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getUpcomingMovies(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getUpcomingMovies()
            result.results?.mapNotNull { it?.toMovie() }
                ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getPlayNow(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getPlayNow()
            result.results?.mapNotNull {
                it?.toMovie()
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getMovieDetails(id: Int): MovieAndSeriesDetails? {
        return try {
            val result = MovieClient.createMoviesService().getMovieDetails(id)
            result.toMovieDetails()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            return null
        }
    }

    suspend fun getSeriesDetails(id: Int): MovieAndSeriesDetails? {
        return try {
            val result = MovieClient.createMoviesService().getSeriesDetails(id)
            result.toSeriesDetails()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            return null
        }
    }

    suspend fun getMovieCredits(id: Int): List<MovieCast> {
        return try {
            val result = MovieClient.createMoviesService().getMovieCredits(id)
            result.cast?.mapNotNull {
                it?.toMovieAndSeriesCast()
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getSeriesCredits(id: Int): List<MovieCast> {
        return try {
            val result = MovieClient.createMoviesService().getSeriesCredits(id)
            result.cast?.mapNotNull {
                it?.toMovieAndSeriesCast()
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getMovieImagesPoster(id: Int): List<MovieAndSeriesImagePoster> {
        return try {
            val result = MovieClient.createMoviesService().getMovieImagesPoster(id)
            result.posters?.mapNotNull {
                it?.toMovieAndSeriesImagePoster()
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getSeriesImagesPoster(id: Int): List<MovieAndSeriesImagePoster> {
        return try {
            val result = MovieClient.createMoviesService().getSeriesImagesPoster(id)
            result.posters?.mapNotNull {
                it?.toMovieAndSeriesImagePoster()
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }
}