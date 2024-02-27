package com.example.mymovieapp.screens.home

import com.example.mymovieapp.MOCKKS
import com.example.mymovieapp.data.repository.MoviesRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockkObject
import io.mockk.unmockkObject
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InteractionImplTest {
    private lateinit var interaction: InteractionImpl


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        interaction = InteractionImpl()
        mockkObject(MoviesRepository)
    }

    @Test
    fun fetchUpcomingMovies() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getUpcomingMovies()
        } coAnswers {
            MOCKKS.resultMovieList
        }
        //act
        interaction.fetchUpcomingMovies {
            //assertion
            Assert.assertEquals(5, it.size)
        }
    }

    @Test
    fun fetchMostPopularMovies() = runTest() {
        //arrange
        coEvery {
            MoviesRepository.getPopularMovies()
        } coAnswers {
            MOCKKS.resultMovieList
        }
        //act
        interaction.fetchMostPopularMovies {
            println("Hello")
            //assertion
            Assert.assertEquals(5, it.size)
        }
    }

    @Test
    fun fetchPlayNowMovies() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getPlayNow()
        } coAnswers {
            MOCKKS.resultMovieList
        }
        //act
        interaction.fetchPlayNowMovies {
            //assertion
            Assert.assertEquals(5, it.size)
        }
    }

    @Test
    fun fetchTopRateMovies() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getTopRate()
        } coAnswers {
            MOCKKS.resultMovieList
        }
        //act
        interaction.fetchTopRateMovies {
            //assertion
            Assert.assertEquals(5, it.size)
        }
    }

    @Test
    fun fetchMostPopularSeries() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getPopularSeries()
        } coAnswers {
            MOCKKS.resultSeriesList
        }
        //act
        interaction.fetchMostPopularSeries {
            //assertion
            Assert.assertEquals(1, it.size)
        }
    }

    @After
    fun tearDown() {
        unmockkObject(MoviesRepository)
    }

}