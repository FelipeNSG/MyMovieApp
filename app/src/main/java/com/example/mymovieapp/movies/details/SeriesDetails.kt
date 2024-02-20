package com.example.mymovieapp.movies.details

import com.example.mymovieapp.network.model.moviedata.Genre
import com.example.mymovieapp.network.model.seriesdata.Genres

data class SeriesDetails(
    override val id: Int,
    override val title: String,
    override val genres:  List<Genres>,
    override val numberOfSeason: Int,
    override val tagline: String,
    override val overview: String,
    override val posterPath: String,
    override val firstAirDate: String,
    override val voteAverage: Double,
    override val episodeRunTime: List<Int>,
    //movie
    override val genre: List<Genre> = emptyList(),
    override val releaseDate: String = "Unknown",
    override val runtime: Int = Int.MIN_VALUE,
    override val type:String = "series"

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
    firstAirDate,
    episodeRunTime
)
