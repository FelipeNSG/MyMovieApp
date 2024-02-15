package com.example.mymovieapp.domain.mappers

import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.Series
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import com.example.mymovieapp.network.model.Result
import com.example.mymovieapp.network.model.movieandseriescredit.Cast
import com.example.mymovieapp.network.model.movieandseriesimages.Poster
import com.example.mymovieapp.network.model.moviedata.MovieId
import com.example.mymovieapp.network.model.seriesdata.SeriesId

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

fun MovieId.toMovieDetails():MovieAndSeriesDetails {
    // mapper
    return MovieAndSeriesDetails(
        id = this.id ?: Int.MIN_VALUE,
        title = this.title ?: "unknown",
        genre = this.genres ?: emptyList(),
        runtime = this.runtime ?: Int.MIN_VALUE,
        tagline = this.tagline ?: "unknown",
        overview = this.overview ?: "unknown",
        posterPath = this.posterPath ?: "default_poster",
        releaseDate = this.releaseDate ?: "unknown",
        voteAverage = this.voteAverage ?: 0.0,
        //series
        type = "movie",
        genres = emptyList(),
        numberOfSeason = Int.MIN_VALUE,
        firstAirDate = "Unknown",
        episodeRunTime = emptyList()
    )
}

fun SeriesId.toSeriesDetails(): MovieAndSeriesDetails {
    return MovieAndSeriesDetails(
        id = this.id ?: Int.MIN_VALUE,
        title = this.name ?: "unknown",
        genres = this.genres ?: emptyList(),
        numberOfSeason = this.numberOfSeasons ?: Int.MIN_VALUE,
        tagline = this.tagline ?: "unknown",
        overview = this.overview ?: "unknown",
        posterPath = this.posterPath ?: "default_poster",
        firstAirDate = this.firstAirDate ?: "unknown",
        voteAverage = this.voteAverage ?: 0.0,
        episodeRunTime = this.episodeRunTime ?: emptyList(),
        //movie
        type = "series",
        genre = emptyList(),
        runtime = Int.MIN_VALUE,
        releaseDate = "Unknown",
    )
}

fun Cast.toMovieAndSeriesCast(): MovieCast {
    return MovieCast(
        originalName = this.originalName ?: "unknown",
        character = this.character ?: "unknown",
        profilePath = this.profilePath ?: "defaultProfilePath"
    )
}

fun Poster.toMovieAndSeriesImagePoster(): MovieAndSeriesImagePoster {
    return MovieAndSeriesImagePoster(
        filePath = this.filePath ?: "defaultProfilePath",
        iso6391 = this.iso6391 ?: "unknown"
    )
}
