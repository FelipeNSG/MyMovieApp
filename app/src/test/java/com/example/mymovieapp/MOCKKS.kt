package com.example.mymovieapp

import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.Series
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import com.example.mymovieapp.network.model.Dates
import com.example.mymovieapp.network.model.MovieList
import com.example.mymovieapp.network.model.MovieListsWithDate
import com.example.mymovieapp.network.model.Result
import com.example.mymovieapp.network.model.movieandseriescredit.Cast
import com.example.mymovieapp.network.model.movieandseriescredit.MovieAndSeriesCredits
import com.example.mymovieapp.network.model.movieandseriesimages.Backdrop
import com.example.mymovieapp.network.model.movieandseriesimages.MovieAndSeriesImages
import com.example.mymovieapp.network.model.movieandseriesimages.Poster
import com.example.mymovieapp.network.model.moviedata.MovieId
import com.example.mymovieapp.network.model.seriesdata.SeriesId
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response

object MOCKKS {
    val typeMovie = "movie"
    val HttpException = HttpException(
        Response.error<ResponseBody>(
            404,
            "Error de internet".toResponseBody("plain/text".toMediaTypeOrNull())
        )
    )
    val resultMovieId = MovieId(
        adult = false,
        backdropPath = "unknown",
        genres = listOf(),
        id = 1111,
        overview = "unknown",
        posterPath = "unknown",
        releaseDate = "unknown",
        runtime = 100,
        tagline = "unknown",
        title = "unknown",
        voteAverage = 9.0

    )
    val resultSeriesId = SeriesId(
        numberOfSeasons = 2,
        backdropPath = "unknown",
        genres = listOf(),
        id = 1111,
        firstAirDate = "unknown",
        name = "unknown",
        overview = "unknown",
        posterPath = "unknown",
        tagline = "unknown",
        voteAverage = 7.7,
        episodeRunTime = listOf()
    )
    val movieListSuccess = MovieList(
        page = 2,
        results = listOf(
            Result(
                adult = false,
                backdropPath = "ok",
                genreIds = listOf(),
                id = 23,
                originalLanguage = "english",
                originalTitle = "unknown",
                overview = "unknown",
                popularity = 23.2,
                posterPath = "unknown",
                releaseDate = "unknown",
                title = "unknown",
                video = false,
                voteAverage = 1.2,
                voteCount = 6
            )
        ),
        totalPages = 20,
        totalResults = 31
    )

    val movieListNotSuccess = MovieList(
        page = 2,
        results = null,
        totalPages = 20,
        totalResults = 31
    )
    val movieListWithDateSuccess = MovieListsWithDate(
        dates = Dates("2024-01-01", "2024-01-01"),
        page = 2,
        results = listOf(
            Result(
                adult = false,
                backdropPath = "ok",
                genreIds = listOf(),
                id = 23,
                originalLanguage = "english",
                originalTitle = "unknown",
                overview = "unknown",
                popularity = 23.2,
                posterPath = "unknown",
                releaseDate = "unknown",
                title = "unknown",
                video = false,
                voteAverage = 1.2,
                voteCount = 6,
            )
        ),
        totalPages = 20,
        totalResults = 31
    )
    val movieListWithDateNotSuccess = MovieListsWithDate(
        dates = Dates("2024-01-01", "2024-01-01"),
        page = 2,
        results = null,
        totalPages = 20,
        totalResults = 31
    )

    val resultMovieList: List<Movie> = (
            listOf(
                Movie(id = 0, title = "title1", url = "", backdropPath = "", type = "movie"),
                Movie(id = 0, title = "title2", url = "", backdropPath = "", type = "movie"),
                Movie(id = 0, title = "title3", url = "", backdropPath = "", type = "movie"),
                Movie(id = 0, title = "title4", url = "", backdropPath = "", type = "movie"),
                Movie(id = 0, title = "title5", url = "", backdropPath = "", type = "movie")
            )
            )
    val resultSeriesList: List<Series> =
        listOf(
            Series(
                id = 9888,
                title = "run",
                url = "http://www.bing.com/search?q=egestas",
                backdropPath = "elite",
                type = "series"
            )
        )
    val resultMovieAndSeriesDetails = MovieAndSeriesDetails(
        type = "something",
        id = 1110,
        title = "Ok",
        genre = listOf(),
        runtime = 120,
        tagline = "unknown",
        overview = "unknown",
        posterPath = "unknown",
        releaseDate = "unknown",
        voteAverage = 0.0,
        genres = listOf(),
        numberOfSeason = 0,
        firstAirDate = "unknown",
        episodeRunTime = listOf()
    )
    val resultMovieAndSeriesImages = MovieAndSeriesImages(
        backdrops = listOf(
            Backdrop(
                aspectRatio = 2.1,
                filePath = "unknown",
                height = 21,
                iso6391 = "unknown",
                voteAverage = 4.4,
                voteCount = 6,
                width = 4

            )
        ),
        posters = listOf(
            Poster(
                aspectRatio = 4.4,
                filePath = "unknown",
                height = 3,
                iso6391 = "unknown",
                voteAverage = 5.8,
                voteCount = 4,
                width = 9
            )
        )
    )
    val resultMovieAndSeriesImagesNotSuccess = MovieAndSeriesImages(
        backdrops = null,
        posters = null,
    )
    val resultMovieAndSeriesCredits = MovieAndSeriesCredits(
        cast = listOf(
            Cast(character = "unknown", originalName = "unknown", profilePath = "unknown")
        )
    )
    val resultMovieAndSeriesCreditsNotSuccess = MovieAndSeriesCredits(
        cast = null
    )
    val resultMovieListCast: List<MovieCast> = listOf(
        MovieCast(
            originalName = "Romeo Keller",
            character = "homero",
            profilePath = "unknown"
        )
    )
    val imagePosterList: List<MovieAndSeriesImagePoster> = listOf(
        MovieAndSeriesImagePoster(
            filePath = "default", iso6391 = "es"
        )
    )
}
