package com.sumin.firstcomposeproject.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sumin.firstcomposeproject.R

@Composable
fun InstagramProfileCard() {
    Card(
        modifier = Modifier
            .padding(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onBackground)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(4.dp),
                painter = painterResource(R.drawable.ic_instagram),
                contentDescription = "Instagram icon"
            )

            UserStatistics(title = "Posts", value = "6,950")
            UserStatistics(title = "Followers", value = "436M")
            UserStatistics(title = "Following", value = "76")
        }
        Column(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    bottom = 8.dp
                )
        ) {
            Text(
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive,
                text = "Instagram"
            )
            Text(
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                text = "#YoursToMake"
            )
            Text(
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                text = "www.facebook.com/emotional_health"
            )
            Button(
                shape = RoundedCornerShape(8.dp),
                onClick = { }) {
                Text(text = "Follow")
            }
        }
    }
}

@Composable
private fun UserStatistics(
    title: String,
    value: String,
) {
    Column(
        modifier = Modifier
            .height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun PreviewCardLight() {
    FirstComposeProjectTheme(
        dynamicColor = false,
        darkTheme = false
    ) {
        InstagramProfileCard()
    }
}

@Preview
@Composable
fun PreviewCardDark() {
    FirstComposeProjectTheme(
        dynamicColor = false,
        darkTheme = true
    ) {
        InstagramProfileCard()
    }
}