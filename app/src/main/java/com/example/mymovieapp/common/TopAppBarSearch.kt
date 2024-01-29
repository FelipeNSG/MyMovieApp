package com.example.mymovieapp.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mymovieapp.R
import com.example.mymovieapp.ui.theme.colorGray
import com.example.mymovieapp.ui.theme.containerColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSearch(modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    TopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
        title = {
            OutlinedTextField(
                modifier = Modifier
                    .width(320.dp)
                    .height(50.dp),
                value = text,
                onValueChange = {
                    text = it
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.app_bar_placeholder))
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.White),
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Icon",
                            tint = colorGray
                        )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter),
                            contentDescription = "Icon",
                            tint = Color(0xFF92929D)
                        )
                    }
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                shape = CircleShape,
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor),
    )
}