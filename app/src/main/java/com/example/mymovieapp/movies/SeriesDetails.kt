package com.example.mymovieapp.movies

import com.example.mymovieapp.network.model.seriesdata.Genre

data class SeriesDetails(
    val id: Int,
    val title: String,
    val genres:  List<Genre?>,
    val numberOfSeason: Int,
    val tagline: String,
    val overview: String,
    val posterPath: String,
    val lastAirDate: String,
    val voteAverage: Double,
    val backdropPath: String,
)
