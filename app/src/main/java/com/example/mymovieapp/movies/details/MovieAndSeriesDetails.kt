package com.example.mymovieapp.movies.details

import com.example.mymovieapp.network.model.moviedata.Genre
import com.example.mymovieapp.network.model.seriesdata.Genres

open class MovieAndSeriesDetails(
    open val type: String,
    //Movie
    open val id: Int,
    open val title: String,
    open val genre: List<Genre>,
    open val runtime: Int,
    open val tagline: String,
    open val overview: String,
    open val posterPath: String,
    open val releaseDate: String,
    open val voteAverage: Double,
    //Series
    open val genres: List<Genres>,
    open val numberOfSeason: Int,
    open val firstAirDate: String,
    open val episodeRunTime: List<Int>
) {
    fun isMovie(): Boolean {
        return type == "movie"
    }
    fun isSeries(): Boolean {
        return type == "series"
    }
}

