package com.example.mymovieapp.screens.details

import com.example.mymovieapp.MOCKKS
import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockkObject
import io.mockk.unmockkObject
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InteractionImplTest {
    private lateinit var interaction: InteractionImpl
    //TODO("RENAME, USE A MEANFUL NAME"
    @Before
    fun setUp() {
        init(this)
        interaction = InteractionImpl()
        mockkObject(MoviesRepository)
    }

    @Test
    fun fetchMovieAndSeriesDetails() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getMovieDetails(any())
        } coAnswers {
            MOCKKS.resultMovieAndSeriesDetails
        }
        //act
        interaction.fetchMovieAndSeriesDetails(10110, "movie") {
            //assertion
            Assert.assertEquals(Stated.Success(MOCKKS.resultMovieAndSeriesDetails), it)
        }
        coVerify {
            MoviesRepository.getMovieDetails(any())
        }
        coVerify(exactly = 0) {
            MoviesRepository.getSeriesDetails(any())
        }
    }

    @Test
    fun fetchMovieAndSeriesDetails2() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getSeriesDetails(any())
        } coAnswers {
            null
        }
        //act
        interaction.fetchMovieAndSeriesDetails(1110, "series") {
            //assertion
            Assert.assertEquals(Stated.Loading, it)
        }

        coVerify {
            MoviesRepository.getSeriesDetails(any())
        }

        coVerify(exactly = 0) {
            MoviesRepository.getMovieDetails(any())
        }
    }

    @Test
    fun fetchMovieCredits() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getMovieCredits(any())
        } coAnswers {
            MOCKKS.resultMovieListCast
        }
        //act
        interaction.fetchMovieCredits(1110, "movie") {
            //assertion
            Assert.assertEquals(MOCKKS.resultMovieListCast, it)
        }
        coVerify {
            MoviesRepository.getMovieCredits(any())
        }
        coVerify(exactly = 0) {
            MoviesRepository.getSeriesCredits(any())
        }
    }

    @Test
    fun fetchMovieCredits2() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getSeriesCredits(any())
        } coAnswers {
            MOCKKS.resultMovieListCast
        }
        //act
        interaction.fetchMovieCredits(1110, "series") {
            //assertion
            Assert.assertNotEquals(emptyList<MovieCast>(), it)
        }
        coVerify {
            MoviesRepository.getSeriesCredits(any())
        }
        coVerify(exactly = 0) {
            MoviesRepository.getMovieCredits(any())
        }
    }

    @Test
    fun fetchImagesPoster() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getMovieImagesPoster(any())
        } coAnswers {
            MOCKKS.imagePosterList
        }
        //act
        interaction.fetchImagesPoster(1110, "movie") {
            //assertion
            Assert.assertEquals(MOCKKS.imagePosterList, it)
        }
        coVerify {
            MoviesRepository.getMovieImagesPoster(any())
        }
        coVerify(exactly = 0) {
            MoviesRepository.getSeriesImagesPoster(any())
        }
    }

    @Test
    fun fetchImagesPoster2() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getSeriesImagesPoster(any())
        } coAnswers {
            MOCKKS.imagePosterList
        }
        //act
        interaction.fetchImagesPoster(1110, "series") {
            //assertion
            Assert.assertNotEquals(emptyList<MovieAndSeriesImagePoster>(), it)
        }
        coVerify {
            MoviesRepository.getSeriesImagesPoster(any())
        }
        coVerify(exactly = 0) {
            MoviesRepository.getMovieImagesPoster(any())
        }
    }

    @After
    fun tearDown() {
        unmockkObject(MoviesRepository)
    }
}