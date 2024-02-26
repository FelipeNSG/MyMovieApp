package com.example.mymovieapp.screens.details

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import io.mockk.MockKAnnotations.init
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
    private val result = MovieAndSeriesDetails(
        type = "something",
        id = 1110,
        title = "Ok",
        genre = listOf(),
        runtime = 120,
        tagline = "unknown",
        overview = "unknown",
        posterPath = "unknown",
        releaseDate = "unknown",
        voteAverage = 0.0,
        genres = listOf(),
        numberOfSeason = 0,
        firstAirDate = "unknown",
        episodeRunTime = listOf()
    )
    private val movieListCast: List<MovieCast> = listOf(
        MovieCast(
            originalName = "Romeo Keller",
            character = "homero",
            profilePath = "unknown"
        )
    )
    private val imagePosterList: List<MovieAndSeriesImagePoster> = listOf(
        MovieAndSeriesImagePoster(
            filePath = "default", iso6391 = "es"
        )
    )

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
            result
        }
        //act
        interaction.fetchMovieAndSeriesDetails(1110, "movie") {
            //assertion
            Assert.assertEquals(Stated.Success(result), it)
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
    }

    @Test
    fun fetchMovieCredits() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getMovieCredits(any())
        } coAnswers {
            movieListCast
        }
        //act
        interaction.fetchMovieCredits(1110, "movie") {
            //assertion
            Assert.assertEquals(movieListCast, it)
        }
    }

    @Test
    fun fetchMovieCredits2() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getSeriesCredits(any())
        } coAnswers {
            movieListCast
        }
        //act
        interaction.fetchMovieCredits(1110, "series") {
            //assertion
            Assert.assertNotEquals(emptyList<MovieCast>(), it)
        }
    }

    @Test
    fun fetchImagesPoster() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getMovieImagesPoster(any())
        } coAnswers {
            imagePosterList
        }
        //act
        interaction.fetchImagesPoster(1110, "movie") {
            //assertion
            Assert.assertEquals(imagePosterList, it)
        }
    }

    @Test
    fun fetchImagesPoster2() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getSeriesImagesPoster(any())
        } coAnswers {
            imagePosterList
        }
        //act
        interaction.fetchImagesPoster(1110, "series") {
            //assertion
            Assert.assertNotEquals(emptyList<MovieAndSeriesImagePoster>(), it)
        }
    }

    @After
    fun tearDown() {
        unmockkObject(MoviesRepository)
    }
}