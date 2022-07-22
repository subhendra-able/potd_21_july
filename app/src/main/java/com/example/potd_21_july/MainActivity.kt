package com.example.potd_21_july

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.potd_21_july.ui.theme.Potd_21_julyTheme
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.util.*

class MainActivity : ComponentActivity() {
    private val client = OkHttpClient()
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    val currentDate = sdf.format(Date())
    var date1 = LocalDate.parse(currentDate)
    var date2 = date1.minus(Duration.ofHours(7))
    val url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=\""+date2+"\"&end_date=\""+date1+"\""
    val request = Request.Builder()
        .url(url)
        .build()
    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {}
        override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Potd_21_julyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

/*@Composable
fun DisplayGrid(b:Intent) {
    LazyRow(

    ) {

    }
}*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Potd_21_julyTheme {

    }
}