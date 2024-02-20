package com.example.mymovieapp.screens.details

import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast

//TODO("CURLY BRACES ARE NOT NEEDED")
interface DetailsContract {

    interface View {
        fun displayMovieDetails(statedDetailsDetails: Stated) {

        }

        fun displayMovieCredits(movieAndSeriesCredits: List<MovieCast>) {

        }

        fun displayImagesPoster(movieAndSeriesImagePoster: List<MovieAndSeriesImagePoster>) {

        }
    }

    interface Presenter {

        fun setView(id: Int, type: String, view: DetailsContract.View)

        fun getMovieDetails() {

        }

        fun getMovieCredits() {

        }

        fun getImagesPoster() {

        }

    }

    interface Model {

        fun fetchMovieAndSeriesDetails(
            id: Int,
            type: String,
            result: (Stated) -> Unit
        ) {

        }

        fun fetchMovieCredits(
            id: Int,
            type: String,
            result: (List<MovieCast>) -> Unit
        ) {

        }

        fun fetchImagesPoster(
            id: Int,
            type: String,
            result: (List<MovieAndSeriesImagePoster>) -> Unit
        ) {

        }

    }
}