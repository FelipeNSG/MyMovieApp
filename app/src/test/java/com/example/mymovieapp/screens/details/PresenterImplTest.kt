package com.example.mymovieapp.screens.details

import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.slot
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class PresenterImplTest {
    private val view = mockk<DetailsContract.View>()
    private val interaction = mockk<DetailsContract.Model>()
    private lateinit var presenter: DetailsContract.Presenter
    private val slotStated = slot<(Stated) -> Unit>()
    private val slotMovieCredits = slot<(List<MovieCast>) -> Unit>()
    private val slotImagesPoster = slot<(List<MovieAndSeriesImagePoster>) -> Unit>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        presenter = PresenterImpl(view, interaction)
    }

    @Test
    fun getMovieDetails() {
        //arrange
        val expectedResult = Stated.Loading
        every {
            interaction.fetchMovieAndSeriesDetails(any(), any(), capture(slotStated))
        } answers {
            slotStated.captured.invoke(expectedResult)
        }
        every { view.displayMovieDetails(expectedResult) } just runs
        //act
        presenter.getMovieDetails()
        //assertion
        verify(exactly = 1) {
            view.displayMovieDetails(expectedResult)
        }
    }

    @Test
    fun getMovieCredits() {
        val expectedResult = listOf(
            MovieCast(
                "Pablo Schreiber",
                "Master Chief, Spartan-117 / John-117",
                "/wOze8R9lgoZxZoTsPSHID4Nt2Ee.jpg"
            )
        )/**/
        //arrange
        every {
            interaction.fetchMovieCredits(any(), any(), capture(slotMovieCredits))
        } answers {
            slotMovieCredits.captured.invoke(expectedResult)
        }
        every { view.displayMovieCredits(expectedResult) } just runs
        //act
        presenter.getMovieCredits()
        //assertion
        verify(exactly = 1) {
            view.displayMovieCredits(expectedResult)
        }
    }

    @Test
    fun getImagesPoster() {
        val expectedResult = listOf(
            MovieAndSeriesImagePoster("en", "/nJUHX3XL1jMkk8honUZnUmudFb9.jpg"),
            MovieAndSeriesImagePoster("en", "/cCjsQpdk89tmJPtIcPIdHQrXCb0.jpg")
        )
        //arrange
        every {
            interaction.fetchImagesPoster(any(), any(), capture(slotImagesPoster))
        } answers {
            slotImagesPoster.captured.invoke(expectedResult)
        }
        every { view.displayImagesPoster(expectedResult) } just runs
        //act
        presenter.getImagesPoster()
        //assertion
        verify(exactly = 1) {
            view.displayImagesPoster(expectedResult)
        }
    }

    @Test
    fun setView() {
        every { presenter.setView(any(), any()) } just runs

        verify(exactly = 1) {
            presenter.setView(any(), any())
        }
    }

    @After
    fun tearDown() {
    }
}