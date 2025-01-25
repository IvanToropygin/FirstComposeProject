package com.sumin.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Not Andro")
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    Greeting(name = "Andro")
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        repeat(10){
            Text(
                text = "\nHello $name!",
                modifier = modifier
            )
        }
    }
}
