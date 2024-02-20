package com.example.mymovieapp.movies.details

import com.example.mymovieapp.network.model.moviedata.Genre
import com.example.mymovieapp.network.model.seriesdata.Genres

data class MovieDetails(
    override val id: Int,
    override val title: String,
    override val genre: List<Genre>,
    override val runtime: Int,
    override val tagline: String,
    override val overview: String,
    override val posterPath: String,
    override val releaseDate: String,
    override val voteAverage: Double,
    //series
    override val genres: List<Genres> = emptyList(),
    override val numberOfSeason: Int = Int.MIN_VALUE,
    override val firstAirDate: String = "Unknown",
    override val episodeRunTime: List<Int> = emptyList(),
    override val type:String = "movie"
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
    firstAirDate,
    episodeRunTime
)
