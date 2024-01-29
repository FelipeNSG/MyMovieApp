package com.example.mymovieapp.data.repository
import android.util.Log
import com.example.mymovieapp.domain.mappers.toMovie
import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.network.client.MovieClient
import retrofit2.HttpException

//TODO("Take a look at the repository pattern")
//TODO("Take a look at the mapper pattern")
//TODO("Take a look at the result pattern")

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