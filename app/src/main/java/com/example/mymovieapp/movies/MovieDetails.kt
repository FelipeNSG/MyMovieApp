package com.example.mymovieapp.movies

import com.example.mymovieapp.network.model.moviedata.Genre

data class MovieDetails(
    val id: Int,
    val title: String,
    val genres: List<Genre>,
    val runtime: Int,
    val tagline: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
)
