package com.example.mymovieapp.network.model.movieandseriescredits


import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("character")
    val character: String?= null,
    @SerializedName("original_name")
    val originalName: String?= null,
    @SerializedName("profile_path")
    val profilePath: String?= null
)