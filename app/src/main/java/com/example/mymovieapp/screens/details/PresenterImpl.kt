package com.example.mymovieapp.screens.details

class PresenterImpl : DetailsContract.Presenter {

    private lateinit var view: DetailsContract.View
    private var id: Int = 0
    private var type: String = ""

    private val interaction: DetailsContract.Model = InteractionImpl()


    override fun setView(id: Int, type: String, view: DetailsContract.View) {
        this.view = view
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