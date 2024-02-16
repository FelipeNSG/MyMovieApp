package com.example.mymovieapp.screens.details

class PresenterImpl : DetailsContract.Presenter {

    private lateinit var view: DetailsContract.View
    private var id: Int = 0
    private var type: String = ""

    private val interaction: DetailsContract.Model = InteractionImpl()

    init {
        getMovieDetails()
        getMovieCredits()
        getImagesPoster()
    }

    override fun setView(id:Int, type:String, view: DetailsContract.View) {
        this.view = view
        this.id = id
        this.type = type
    }


    override fun getMovieDetails() {
            when (id != 0 && type != ""){
                true -> interaction.fetchMovieAndSeriesDetails(id, type){
                    view.displayMovieDetails(it)
                }
                false -> TODO()
            }
    }

    override fun getMovieCredits() {

    }

    override fun getImagesPoster() {

    }
}