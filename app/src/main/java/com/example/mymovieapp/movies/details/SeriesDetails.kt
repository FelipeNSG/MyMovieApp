package com.example.mymovieapp.movies.details

import com.example.mymovieapp.network.model.moviedata.Genre
import com.example.mymovieapp.network.model.seriesdata.Genres

data class SeriesDetails(
    val id: Int,
    val title: String,
    val genres:  List<Genres>,
    val numberOfSeason: Int,
    val tagline: String,
    val overview: String,
    val posterPath: String,
    val lastAirDate: String,
    val voteAverage: Double,
    //movie
    val genre: List<Genre> = emptyList(),
    val releaseDate: String = "Unknown",
    val runtime: Int = Int.MIN_VALUE,
    val type:String = "series"

):MovieAndSeriesDetails(
    type,
    id ,
    title,
    genre,
    runtime,
    tagline,
    overview,
    posterPath,
    releaseDate,
    voteAverage,
    genres,
    numberOfSeason,
    lastAirDate
)
