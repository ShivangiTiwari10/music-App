package com.example.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.musicapp.ui.theme.MusicAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nav()
        }
    }
}

@Composable
fun Greeting( navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.nicolasunsplash),
            contentDescription = "",

            contentScale = ContentScale.Crop,

            modifier = Modifier.fillMaxHeight()// Stretch the image to fill the entire space
        )
    }

        Column(
            modifier = Modifier.padding(top = 24.dp), Arrangement.Bottom

        ) {
            Text(
                text = "Enjoy Your \n favorite music",
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Left,
                fontSize = 50.sp,
                color = Color.Yellow,
                modifier = Modifier.padding()
            )

                Button(onClick = { navController.navigate("ScreenA") }) {
                    Text(text = "Get Started")
                }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Continue with email")
            }
        }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MusicAppTheme {
//        Greeting()
    }
}