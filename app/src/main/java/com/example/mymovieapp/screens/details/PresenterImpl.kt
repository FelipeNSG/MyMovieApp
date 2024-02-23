package com.example.mymovieapp.screens.details

class PresenterImpl(
    private val view: DetailsContract.View,
    private val interaction: DetailsContract.Model

) : DetailsContract.Presenter {

    private var id: Int = 0
    private var type: String = ""

    override fun setView(id: Int, type: String) {
        this.id = id
        this.type = type

        getMovieDetails()
        getMovieCredits()
        getImagesPoster()
    }

    override fun getMovieDetails() {
        interaction.fetchMovieAndSeriesDetails(id, type) {
            view.displayMovieDetails(it)
        }
    }

    override fun getMovieCredits() {
        interaction.fetchMovieCredits(id, type) {
            view.displayMovieCredits(it)
        }
    }

    override fun getImagesPoster() {
        interaction.fetchImagesPoster(id, type) {
            view.displayImagesPoster(it)
        }
    }
}