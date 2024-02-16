package com.example.mymovieapp.screens.details

import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import com.example.mymovieapp.network.model.movieandseriescredit.MovieAndSeriesCredits

interface DetailsContract {

    interface View {
        fun displayMovieDetails(movieAndSeriesDetails: MovieAndSeriesDetails) {

        }

        fun displayMovieCredits(movieAndSeriesCredits: List<MovieAndSeriesCredits>) {

        }

        fun displayImagesPoster(movieAndSeriesImagePoster: List<MovieAndSeriesImagePoster>) {

        }
    }

    interface Presenter {

        fun setView(id:Int, type:String, view : DetailsContract.View)
        fun setId(id:Int){

        }
        fun setType(type: String){

        }

        fun getMovieDetails() {

        }

        fun getMovieCredits() {

        }

        fun getImagesPoster() {

        }

    }

    interface Model {

        fun fetchMovieAndSeriesDetails(id:Int, type:String, result: (MovieAndSeriesDetails) -> Unit) {

        }

        fun fetchMovieCredits(id:Int,type:String,result: List<MovieAndSeriesCredits>) {

        }

        fun fetchImagesPoster(id:Int,type:String,result: List<MovieAndSeriesImagePoster>) {

        }

    }

}