package com.example.mymovieapp.network.model.movieandseriescredits


import com.google.gson.annotations.SerializedName

data class MovieAndSeriesCredits(
    @SerializedName("cast")
    val cast: List<Cast?>?= null,
)
