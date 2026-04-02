package com.example.news_app.data.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsDto>
)

data class NewsDto(
    val id: Int,
    val title: String,
    val description: String,
)

