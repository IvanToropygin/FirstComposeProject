package com.sumin.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Test(viewModel: MainViewModel) {
    FirstComposeProjectTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            val models = viewModel.models.observeAsState(listOf())
            LazyColumn {
                items(items = models.value, key = { it.id }) { model ->
                    val dismissThresholds = with(receiver = LocalDensity.current) {
                        LocalConfiguration.current.screenWidthDp.dp.toPx() * 0.9F
                    }
                    val dismissState = rememberSwipeToDismissBoxState(
                        positionalThreshold = { dismissThresholds },
                        confirmValueChange = { value ->
                            val isDismissed = value in setOf(
                                SwipeToDismissBoxValue.StartToEnd,//не обязателен т.к свайп справа налево
                                SwipeToDismissBoxValue.EndToStart,// обязателен
                            )
                            if (isDismissed) {
                                viewModel.delete(model)
                            }
                            return@rememberSwipeToDismissBoxState isDismissed// Возвращает результат, подтверждающий, что свайп выполнен
                        }
                    )
                    SwipeToDismissBox(
                        state = dismissState,
                        enableDismissFromEndToStart = true,//для свайпа справа налево
                        enableDismissFromStartToEnd = false,//для свайпа слева направо
                        backgroundContent = {
                            Box(// Фон для отображения во время свайпа, сигнализирующий об удалении
                                modifier = Modifier
                                    .padding(30.dp)
                                    .fillMaxSize()
                                    .background(Color.Red),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(16.dp),
                                    text = "Proceed swipe\nto Delete",
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }
                        },
                    ) {
                        InstagramProfileCard(
                            instagramModel = model,
                            onFollowedButtonClickListener = {
                                viewModel.changeFollowingStatus(it)
                            }
                        )
                    }
                }
            }
        }
    }
}
