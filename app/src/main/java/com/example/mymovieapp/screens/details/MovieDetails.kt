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
import androidx.navigation.NavHostController
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

@Composable
fun Details(
    navController: NavHostController,
    movieCredits: List<MovieCast>,
    movieAndSeriesImagePoster: List<MovieAndSeriesImagePoster>,
    movieAndSeriesDetails: MovieAndSeriesDetails
) {
    val storyLine = movieAndSeriesDetails._overview

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(containerColor),

        ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp),
            model = imageMovieUrl(movieAndSeriesDetails._posterPath),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.15f
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            TopAppBarTemplate(
                title = movieAndSeriesDetails._title,
                secondIcon = true,
                navController
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                SubcomposeAsyncImage(
                    modifier = Modifier
                        .width(260.dp)
                        .height(360.dp),
                    model = imageMovieUrl(movieAndSeriesDetails._posterPath),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .height(18.dp)
                            .padding(horizontal = 8.dp),
                        painter = painterResource(id = R.drawable.calendar),
                        tint = colorGray,
                        contentDescription = null
                    )
                    Text(
                        text = "2024",
                        color = colorGray,
                        )
                    Icon(
                        modifier = Modifier
                            .height(18.dp)
                            .padding(horizontal = 8.dp),
                        painter = painterResource(id = R.drawable.separator),
                        tint = colorGray,
                        contentDescription = null
                    )
                    Icon(
                        modifier = Modifier
                            .height(18.dp)
                            .padding(end = 8.dp),
                        imageVector = Icons.Default.Schedule,
                        contentDescription = "Duration",
                        tint = colorGray
                    )
                    if (movieAndSeriesDetails._type == "movie"){
                        Text(
                            text = "${movieAndSeriesDetails._runtime} minutes",
                            color = colorGray,
                        )
                    }else {
                        Text(
                            text = "100 minutes",
                            color = colorGray,
                        )
                    }

                    Icon(
                        modifier = Modifier
                            .height(18.dp)
                            .padding(horizontal = 8.dp),
                        painter = painterResource(id = R.drawable.separator),
                        tint = colorGray,
                        contentDescription = null
                    )
                    Icon(
                        modifier = Modifier.height(18.dp),
                        painter = painterResource(id = R.drawable.category),
                        tint = colorGray,
                        contentDescription = null
                    )
                    if (movieAndSeriesDetails._type == "movie"){
                        Text(
                            text = movieAndSeriesDetails._genre[0].name,
                            color = colorGray,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    } else {
                        Text(
                            text = movieAndSeriesDetails._genres[0].name,
                            color = colorGray,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }

                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "Duration",
                        tint = colorOrange
                    )
                    Text(text = String.format("%.1f", (movieAndSeriesDetails._voteAverage)),
                        color = colorOrange
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
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
                                contentDescription = "Duration",
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
                            contentDescription = "content description",
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
                            contentDescription = "content description",
                            tint = colorBlue
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    if (movieAndSeriesDetails._tagline != "") {
                        Text(
                            text = "Tag Line",
                            style = TextStyle(
                                fontSize = 17.sp,
                                fontFamily = FontFamily(Font(R.font.montserrat)),
                                color = Color.White,
                            )
                        )

                        Text(
                            text = movieAndSeriesDetails._tagline,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.montserrat)),
                                color = Color.White,
                            ),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

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
                    Text(
                        text = "Cast",
                        style = TextStyle(
                            fontSize = 17.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            color = Color.White,
                        )
                    )
                    Profiles(movieCredits)
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
            }
        }
    }
}

@Composable
fun MovieDetails(navController: NavHostController, id: Int?, type: String?) {
    val detailsController = DetailsController(
        DetailsModel()
    )

    var movieAndSeriesDetails: MovieAndSeriesDetails? by remember {
        mutableStateOf(null)
    }

    var movieAndSeriesCredits by remember {
        mutableStateOf(emptyList<MovieCast>())
    }
    var movieAndSeriesImagePoster by remember {
        mutableStateOf(emptyList<MovieAndSeriesImagePoster>())
    }

    LaunchedEffect(Unit) {
        if (id != null && type == "movie") {
            detailsController.getMovieDetails(id) {
                movieAndSeriesDetails = it
            }
            detailsController.getMovieCredits(id) { credits ->
                movieAndSeriesCredits = credits.filter { it.profilePath != "defaultProfilePath" }
            }
            detailsController.getMovieImagesPoster(id) { images ->
                movieAndSeriesImagePoster = images.filter { it.iso6391 == "en" }.shuffled()
            }
        }
        if (id != null && type == "series") {
            detailsController.getSeriesDetails(id) {
                movieAndSeriesDetails = it
            }
            detailsController.getSeriesCredits(id) { credits ->
                movieAndSeriesCredits = credits.filter { it.profilePath != "defaultProfilePath" }
            }
            detailsController.getSeriesImagesPoster(id) { images ->
                movieAndSeriesImagePoster = images.filter { it.iso6391 == "en" }.shuffled()
            }
        }
    }

    if (movieAndSeriesDetails != null) {
        BodyTemplate(
            container = containerColor,
            topBar = { },
            bottomBar = { },
            body = {
                Details(
                    navController,
                    movieAndSeriesCredits,
                    movieAndSeriesImagePoster,
                    movieAndSeriesDetails!!
                )
            }
        )
    }
}

