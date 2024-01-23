package com.example.mymovieapp.data.repository
import android.util.Log
import com.example.mymovieapp.network.client.MovieClient
import com.example.mymovieapp.domain.mappers.toMovie
import com.example.mymovieapp.movies.Movie
import retrofit2.HttpException

// Repository
object MoviesRepository {

    suspend fun getPopularMovies(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getPopularMovies()
            result.results?.map { it?.toMovie() }?.filterNotNull()?.apply {
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
            result.results?.map { it?.toMovie() }?.filterNotNull()?.apply {
                Log.i("size", this.size.toString())
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getPopularSeries(): List<Movie> {
        return try {
            val result = MovieClient.createMoviesService().getPopularSeries()
            result.results?.map { it?.toMovie() }?.filterNotNull()?.apply {
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
            result.results?.map { it?.toMovie() }?.filterNotNull()?.apply {
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
            result.results?.map { it?.toMovie() }?.filterNotNull()?.apply {
                Log.i("size", this.size.toString())
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

}