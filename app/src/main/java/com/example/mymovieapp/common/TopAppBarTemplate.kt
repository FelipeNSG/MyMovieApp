package com.example.mymovieapp.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mymovieapp.R
import com.example.mymovieapp.ui.theme.colorWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarTemplate(title: String?, secondIcon: Boolean, navController: NavHostController ) {
    Row {

        CenterAlignedTopAppBar(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp),

            title = {
                if (title.isNullOrEmpty()) {
                    Text(text = "")
                } else {
                    if (title.length > 16){
                        Text(text = title.take(16).trimEnd().plus("..."),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.montserrat))
                        )
                    } else {
                        Text(text = title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.montserrat))
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(Color.Transparent),
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Icon",
                        tint = colorWhite
                    )
                }
            },
            actions = {
                if (secondIcon) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Icon",
                            tint = colorWhite
                        )
                    }
                } else {

                }
            }
        )
    }


}