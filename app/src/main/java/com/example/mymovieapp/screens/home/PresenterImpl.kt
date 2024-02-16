package com.example.mymovieapp.screens.home

class PresenterImpl : HomeContract.Presenter {

    private lateinit var view: HomeContract.View
    private val interaction: HomeContract.Model = InteractionImpl()

    init {
        getMostPopularMovies()
    }
    override fun setView(view: HomeContract.View) {
        this.view = view
    }

    override fun getUpcomingMovies() {

    }

    override fun getMostPopularMovies() {
        interaction.fetchMostPopularMovies {
            view.displayMostPopularMovies(it)
        }
    }

    override fun getTopRateMovies() {

    }
}