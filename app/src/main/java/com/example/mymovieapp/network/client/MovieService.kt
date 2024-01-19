package com.example.mymovieapp.network.client

import com.example.mymovieapp.network.model.PopularMovies
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieService {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(): PopularMovies

}