package com.example.mymovieapp.screens.home

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.slot
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class InteractionImplTest {
    private val moviesRepository: MoviesRepository = mockk()
    private lateinit var interaction: InteractionImpl
    private var slotMovie = slot<(List<Movie>) -> Unit>()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        interaction = spyk()
    }

    @Test
    fun fetchUpcomingMovies() {
        runBlocking {

             var movieList: List<Movie> = emptyList()
            coEvery {
                moviesRepository.getUpcomingMovies()
            }answers {
                movieList
            }

            interaction.fetchUpcomingMovies {
                print("movie size ${it.size}")
            }
        }

    }

    @After
    fun tearDown() {
    }
}