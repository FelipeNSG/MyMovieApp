package com.example.mymovieapp.network.client

import com.example.mymovieapp.network.model.MovieIdData.MovieId
import com.example.mymovieapp.network.model.MovieList
import com.example.mymovieapp.network.model.MovieListsWithDate
import com.example.mymovieapp.network.model.SeriesIdData.SeriesId
import retrofit2.http.GET
import retrofit2.http.Path


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

    @GET("3/movie/{id}?language=en-US")
    suspend fun getMovieDetails(@Path("id") id: Int): MovieId
    @GET("3/tv/{id}?language=en-US")
    suspend fun getSeriesDetails(@Path("id") id: Int): SeriesId


}

