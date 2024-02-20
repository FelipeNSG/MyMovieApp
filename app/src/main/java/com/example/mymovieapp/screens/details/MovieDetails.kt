package com.example.mymovieapp.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.mymovieapp.R
import com.example.mymovieapp.common.BodyTemplate
import com.example.mymovieapp.common.ImageLazyRow
import com.example.mymovieapp.common.Profiles
import com.example.mymovieapp.common.TopAppBarTemplate
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import com.example.mymovieapp.movies.imageMovieUrl
import com.example.mymovieapp.ui.theme.colorBlue
import com.example.mymovieapp.ui.theme.colorGray
import com.example.mymovieapp.ui.theme.colorLightBlack
import com.example.mymovieapp.ui.theme.colorOrange
import com.example.mymovieapp.ui.theme.colorWhite
import com.example.mymovieapp.ui.theme.containerColor

typealias CallbackNavController = () -> Unit

@Composable
fun MovieDetails(
    id: Int,
    type: String,
    callbackNavController: CallbackNavController,
) {
    var movieOrSeriesDetails: Stated by remember {
        mutableStateOf(Stated.Loading)
    }

    var movieOrSeriesCredits: List<MovieCast> by remember {
        mutableStateOf(emptyList())
    }
    var movieOrSeriesImagesPoster: List<MovieAndSeriesImagePoster> by remember {
        mutableStateOf(emptyList())
    }


    val presenter: DetailsContract.Presenter = PresenterImpl()
    val detailsView: DetailsContract.View = object : DetailsContract.View {
        override fun displayMovieDetails(stateDetails: Stated) {
            movieOrSeriesDetails = stateDetails
        }

        override fun displayMovieCredits(movieAndSeriesCredits: List<MovieCast>) {
            movieOrSeriesCredits = movieAndSeriesCredits
        }

        override fun displayImagesPoster(movieAndSeriesImagePoster: List<MovieAndSeriesImagePoster>) {
            movieOrSeriesImagesPoster = movieAndSeriesImagePoster
        }
    }
    LaunchedEffect(Unit){
        presenter.setView(id, type, detailsView)
    }

        when (movieOrSeriesDetails){
            Stated.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = containerColor),
                )

            }
            is Stated.Success -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = containerColor),
                ){

                    BodyTemplate(
                        container = containerColor,
                        topBar = { },
                        bottomBar = { },
                        body = {
                            Details(
                                movieOrSeriesCredits,
                                movieOrSeriesImagesPoster,
                                (movieOrSeriesDetails as Stated.Success).details,
                                callbackNavController
                            )
                        }
                    )
                }
            }
        }


}

@Composable
fun Details(
    movieCredits: List<MovieCast>,
    movieAndSeriesImagePoster: List<MovieAndSeriesImagePoster>,
    movieAndSeriesDetails: MovieAndSeriesDetails,
    callbackNavController: () -> Unit
) {
    val storyLine = movieAndSeriesDetails.overview
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        ImageFromTheMovieOrSeriesForScreenBackground(movieAndSeriesDetails = movieAndSeriesDetails)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            TopAppBarTemplate(
                title = movieAndSeriesDetails.title,
                secondIcon = true,
                callbackNavController
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                MainImageOfTheMovieOrSeries(movieAndSeriesDetails = movieAndSeriesDetails)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    ShowCalendarIconAndReleaseYearOfTheMovieOrSeries(movieAndSeriesDetails = movieAndSeriesDetails)
                    ShowIconToSeparateContent()
                    ShowTimeIconAndDurationOfTheMovieOrSeries(movieAndSeriesDetails = movieAndSeriesDetails)
                    ShowIconToSeparateContent()
                    ShowDescriptionIconAndCategoryOfTheMovieOrSeries(movieAndSeriesDetails = movieAndSeriesDetails)
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    ShowRatingOfMovieOrSeries(movieAndSeriesDetails = movieAndSeriesDetails)
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    ShowButtonPlayDownloadAndShare()
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ShowTagLine(movieAndSeriesDetails = movieAndSeriesDetails)
                    ShowStoryLine(storyLine = storyLine)
                    ShowCastImage(movieCredits = movieCredits)
                    ShowImageGallery(movieAndSeriesImagePoster = movieAndSeriesImagePoster)
                }
            }
        }
    }
}

@Composable
fun ImageFromTheMovieOrSeriesForScreenBackground(movieAndSeriesDetails: MovieAndSeriesDetails) {
    SubcomposeAsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(550.dp),
        model = imageMovieUrl(movieAndSeriesDetails.posterPath),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = 0.15f
    )
}

@Composable
fun MainImageOfTheMovieOrSeries(movieAndSeriesDetails: MovieAndSeriesDetails) {
    SubcomposeAsyncImage(
        modifier = Modifier
            .width(260.dp)
            .height(360.dp),
        model = imageMovieUrl(movieAndSeriesDetails.posterPath),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun ShowCalendarIconAndReleaseYearOfTheMovieOrSeries(movieAndSeriesDetails: MovieAndSeriesDetails) {
    Icon(
        modifier = Modifier
            .height(18.dp)
            .padding(horizontal = 8.dp),
        painter = painterResource(id = R.drawable.calendar),
        tint = colorGray,
        contentDescription = null
    )
    if (movieAndSeriesDetails.isMovie()) {
        Text(
            text = movieAndSeriesDetails.releaseDate.take(4),
            color = colorGray,
        )
    } else {
        Text(
            text = movieAndSeriesDetails.firstAirDate.take(4),
            color = colorGray,
        )
    }
}

@Composable
fun ShowIconToSeparateContent() {
    Icon(
        modifier = Modifier
            .height(18.dp)
            .padding(horizontal = 8.dp),
        painter = painterResource(id = R.drawable.separator),
        tint = colorGray,
        contentDescription = R.string.icon_to_separated_Content.toString()
    )
}

@Composable
fun ShowTimeIconAndDurationOfTheMovieOrSeries(movieAndSeriesDetails: MovieAndSeriesDetails) {
    Icon(
        modifier = Modifier
            .height(18.dp)
            .padding(end = 8.dp),
        imageVector = Icons.Default.Schedule,
        contentDescription = R.string.duration.toString(),
        tint = colorGray
    )
    if (movieAndSeriesDetails.isMovie() && movieAndSeriesDetails.runtime != 0) {
        Text(
            text = "${movieAndSeriesDetails.runtime} minutes",
            color = colorGray,
        )
    } else if (movieAndSeriesDetails.isSeries() && movieAndSeriesDetails.episodeRunTime.isNotEmpty()) {
        Text(
            text = "${movieAndSeriesDetails.episodeRunTime[0]} minutes",
            color = colorGray,
        )
    } else {
        //TODO("AVOID TO USE HARDCODE VALUES")
        Text(
            text = stringResource(id = R.string.not_available),
            color = colorGray,
        )
    }
}

@Composable
fun ShowDescriptionIconAndCategoryOfTheMovieOrSeries(movieAndSeriesDetails: MovieAndSeriesDetails) {
    Icon(
        modifier = Modifier.height(18.dp),
        painter = painterResource(id = R.drawable.category),
        tint = colorGray,
        contentDescription = "Icon Category"
    )
    if (movieAndSeriesDetails.type == "Movie" && (movieAndSeriesDetails.genre.isNotEmpty())) {
        Text(
            text = movieAndSeriesDetails.genre[0].name,
            color = colorGray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    } else if (movieAndSeriesDetails.type == "Series" && (movieAndSeriesDetails.genres.isNotEmpty())){
        Text(
            text = movieAndSeriesDetails.genres[0].name,
            color = colorGray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }else {
        Text(
            text = stringResource(id = R.string.not_available),
            color = colorGray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
fun ShowRatingOfMovieOrSeries(movieAndSeriesDetails: MovieAndSeriesDetails) {
    Icon(
        painter = painterResource(id = R.drawable.star),
        contentDescription = "Star Icon",
        tint = colorOrange
    )
    Text(
        text = String.format("%.1f", (movieAndSeriesDetails.voteAverage)),
        color = colorOrange
    )
}

@Composable
fun ShowButtonPlayDownloadAndShare() {
    Button(modifier = Modifier
        .width(110.dp)
        .height(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorOrange
        ),
        onClick = { /*TODO*/ },
        content = {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Button Play",
                tint = colorWhite
            )
            Text(
                text = "Play", modifier = Modifier.padding(start = 6.dp)
            )
        }
    )
    IconButton(
        onClick = { },
        modifier = Modifier
            .clip(CircleShape)
            .size(40.dp),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = colorLightBlack
        )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.download),
            contentDescription = "Button Download",
            tint = colorOrange
        )

    }
    IconButton(
        onClick = { },
        modifier = Modifier
            .clip(CircleShape)
            .size(40.dp),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = colorLightBlack
        )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.share),
            contentDescription = "Button Share",
            tint = colorBlue
        )
    }
}

@Composable
fun ShowTagLine(movieAndSeriesDetails: MovieAndSeriesDetails) {
    //TODO("THIS LOGIC COULD BE IN OTHER PLACE, LIKE THE MODEL IT BELONGS?")
    if (movieAndSeriesDetails.tagline.isNotEmpty()) {
        Text(
            text = "Tag Line",
            style = TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color.White,
            )
        )
        Text(
            text = movieAndSeriesDetails.tagline,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color.White,
            ),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ShowStoryLine(storyLine: String) {
    if (storyLine.isNotEmpty()) {
        Text(
            text = "Story Line",
            style = TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color.White,
            )
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = colorWhite,
                        fontFamily = FontFamily(Font(R.font.montserrat))
                    )
                ) {
                    if (storyLine.length <= 60 && storyLine.endsWith(".")) {
                        append(storyLine.plus("..."))
                    } else append(storyLine.substring(0, 59))

                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = colorBlue
                    )
                ) {
                    if (storyLine.length > 60) {
                        append(" More")
                    }
                }
            },
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ShowCastImage(movieCredits: List<MovieCast>) {
    if (movieCredits.isNotEmpty()) {
        Text(
            text = "Cast",
            style = TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color.White,
            )
        )
        Profiles(movieCredits)
    }
}

@Composable
fun ShowImageGallery(movieAndSeriesImagePoster: List<MovieAndSeriesImagePoster>) {
    if (movieAndSeriesImagePoster.isNotEmpty()) {
        Text(
            text = "Gallery",
            style = TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color.White,
            )
        )
        ImageLazyRow(movieAndSeriesImagePoster)
    }
}


