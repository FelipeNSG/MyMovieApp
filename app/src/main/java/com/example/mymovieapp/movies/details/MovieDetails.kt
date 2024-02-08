package com.example.mymovieapp.movies.details

import com.example.mymovieapp.network.model.moviedata.Genre
import com.example.mymovieapp.network.model.seriesdata.Genres

data class MovieDetails(
    val id: Int,
    val title: String,
    val genre: List<Genre>,
    val runtime: Int,
    val tagline: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    //series
    val genres: List<Genres> = emptyList(),
    val numberOfSeason: Int = Int.MIN_VALUE,
    val lastAirDate: String = "Unknown",
    val type:String = "movie"
):MovieAndSeriesDetails(
    type,
    id ,
    title ,
    genre ,
    runtime ,
    tagline ,
    overview ,
    posterPath,
    releaseDate ,
    voteAverage ,
    genres,
    numberOfSeason,
    lastAirDate,
)
