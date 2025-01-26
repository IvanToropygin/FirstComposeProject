package com.sumin.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sumin.firstcomposeproject.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramProfileCard()
        }
    }
}

@Preview
@Composable
fun CardTest() {
    Card(
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        colors = CardDefaults.cardColors(Color.Green)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "Hello world!",
            color = Color.White
        )
    }
}
