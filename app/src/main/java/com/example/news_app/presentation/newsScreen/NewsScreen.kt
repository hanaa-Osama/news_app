package com.example.news_app.presentation.newsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.news_app.presentation.newsScreen.component.NewsItem

@Composable
fun NewsScreen(
    userName: String,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val newsList by viewModel.newsState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Hi, $userName",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(newsList) { news ->
                NewsItem(news = news)
            }
        }
    }
}