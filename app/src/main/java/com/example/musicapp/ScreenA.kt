package com.example.musicapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ScreenA(viewModel: SongListModel = viewModel()) {

    LaunchedEffect(key1 = Unit) {
        val apiKey = "YOUR_RAPID_API_KEY"
        viewModel.getPlayList(apiKey)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box {
            Image(
                painter = painterResource(id = R.drawable.micheunsplash),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp, 300.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(text = "F.L.M", fontSize = 30.sp, color = Color.Magenta)
        }

        SongListModel()

        Row {
            Text(text = "Positive Singles", textAlign = TextAlign.Left)
            Text(text = "view All", textAlign = TextAlign.End)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp, 300.dp),
        ) {
            PlayList()

        }
        Albums()

    }
}


@Composable
fun PlayListCard() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.wesunsplash),
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Paint It", fontSize = 20.sp,
                )
                Text(
                    text = "2024", fontSize = 15.sp,
                )
            }
        }
    }
}

@Composable
fun AlbumCard() {
    Box(
        modifier = Modifier
            .background(Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.wesunsplash),
                contentDescription = "",
                modifier = Modifier
                    .padding(10.dp)
                    .size(110.dp, 120.dp)
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Title", fontSize = 20.sp
                )
                Text(text = "Description", fontSize = 15.sp)
            }
        }
    }

}

data class User(val id: Int)

val Users = listOf(

    User(1),
    User(2),
    User(3),
    User(4),
    User(5),
    User(6),
    User(7),
    User(8)
)

data class Album(val id: Int)

val Albums = listOf(
    Album(1),
    Album(2),
)

@Composable
fun PlayList() {

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (i in 1..10) {
            PlayListCard()
        }
    }
    LazyColumn {
        items(Users) {
            PlayListCard()
        }
    }
}

@Composable
fun Albums() {
    Column(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        for (i in 1..5) {
            AlbumCard()
        }
    }
    LazyColumn {
        items(Albums) {
            AlbumCard()
        }
    }
}




@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    ScreenA()

}