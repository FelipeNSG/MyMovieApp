package com.example.mymovieapp.network.client

import com.example.mymovieapp.network.model.MovieList
import com.example.mymovieapp.network.model.MovieListsWithDate
import retrofit2.http.GET

interface MovieService {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(): MovieList

    @GET("3/movie/upcoming")
    suspend fun getUpcomingMovies(): MovieListsWithDate

    @GET("3/movie/now_playing?language=en-US&page=1")
    suspend fun getPlayNow(): MovieListsWithDate

    @GET("3/movie/top_rated?language=en-US&page=3")
    suspend fun getTopRate(): MovieList

    @GET("3/tv/popular?language=en-US&page=1")
    suspend fun getPopularSeries(): MovieList

}

