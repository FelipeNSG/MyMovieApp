package com.example.mymovieapp.domain.mappers

import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.MovieDetails
import com.example.mymovieapp.movies.Series
import com.example.mymovieapp.movies.SeriesDetails
import com.example.mymovieapp.network.model.MovieIdData.MovieId
import com.example.mymovieapp.network.model.Result
import com.example.mymovieapp.network.model.SeriesIdData.SeriesId

fun Result.toMovie(): Movie {
    // mapper
    return Movie(
        id = this.id ?: Int.MIN_VALUE,
        title = this.title ?: "unknown",
        url = this.posterPath ?: "default_url",
        backdropPath = this.backdropPath ?: "default_url"
    )
}

fun Result.toSeries(): Series {
    // mapper
    return Series(
        id = this.id ?: Int.MIN_VALUE,
        title = this.title ?: "unknown",
        url = this.posterPath ?: "default_url",
        backdropPath = this.backdropPath ?: "default_url"
    )
}

fun MovieId.toMovieDetails(): MovieDetails {
    // mapper
    return MovieDetails(
        id = this.id ?: Int.MIN_VALUE,
        title = this.title ?: "unknown",
        genres = this.genres ?: emptyList(),
        runtime = this.runtime ?: Int.MIN_VALUE,
        tagline = this.tagline ?: "unknown",
        overview = this.overview ?: "unknown",
        posterPath = this.posterPath ?: "default_poster",
        releaseDate = this.releaseDate ?: "unknown",
        voteAverage = this.voteAverage ?: 0.0,
        backdropPath = this.backdropPath ?: "default_backdropPath"
    )
}

fun SeriesId.toSeriesDetails(): SeriesDetails {
    return SeriesDetails(
        id = this.id ?: Int.MIN_VALUE,
        title = this.name ?: "unknown",
        genres = this.genres ?: emptyList(),
        numberOfSeason = this.numberOfSeasons ?: Int.MIN_VALUE,
        tagline = this.tagline ?: "unknown",
        overview = this.overview ?: "unknown",
        posterPath = this.posterPath ?: "default_poster",
        lastAirDate = this.lastAirDate ?: "unknown",
        voteAverage = this.voteAverage ?: 0.0,
        backdropPath = this.backdropPath ?: "default_backdropPath"
    )
}