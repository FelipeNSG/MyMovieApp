package com.example.mymovieapp.data.repository
import android.util.Log
import com.example.mymovieapp.network.client.MovieClient
import com.example.mymovieapp.domain.mappers.toMovie
import com.example.mymovieapp.movies.MoviesMostPopular
import retrofit2.HttpException
import kotlin.math.log

// Repository
object MoviesRepository {

    suspend fun getPopularMovies(): List<MoviesMostPopular> {
        return try {
            val result = MovieClient.createMoviesService().getPopularMovies()
            result.results?.take(10)?.map { it?.toMovie() }?.filterNotNull()?.apply {
                Log.i("size", this.size.toString())
            } ?: emptyList()
        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

    suspend fun getWorstMovies(): List<MoviesMostPopular> {
        return try {
            val result = MovieClient.createMoviesService().getPopularMovies()
            result.results?.map { it?.toMovie() }?.filterNotNull() ?: emptyList()

        } catch (ex: HttpException) {
            ex.printStackTrace()
            emptyList()
        }
    }

}