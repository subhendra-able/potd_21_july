package com.example.potd_21_july

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.potd_21_july.ui.theme.Potd_21_julyTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Potd_21_julyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2017-07-14&end_date=2017-07-21"
                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(browserIntent)
                    DisplayGrid()
                }
            }
        }
    }
}

@Composable
fun DisplayGrid() {
    LazyRow(

    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Potd_21_julyTheme {
        DisplayGrid()
    }
}