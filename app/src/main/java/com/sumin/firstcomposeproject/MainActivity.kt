package com.sumin.firstcomposeproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.sumin.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.sumin.firstcomposeproject.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[MainViewModel()::class.java]
        setContent {
            Test(viewModel)
        }
    }
}

@Composable
private fun Test(viewModel: MainViewModel) {
    FirstComposeProjectTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            val models = viewModel.models.observeAsState(listOf())
            LazyColumn {
                items(models.value) { model ->
                    Log.d("MainActivity001", "InstagramProfileCard $model")
                    InstagramProfileCard(
                        model,
                        onFollowedButtonClickListener = { clickedModel ->
                            viewModel.changeFollowingStatus(clickedModel) }
                    )
                }
            }
        }
    }
}
