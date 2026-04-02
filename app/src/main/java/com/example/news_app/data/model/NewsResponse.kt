package com.example.news_app.data.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsDto>
)

data class NewsDto(
    val idNews: Int,
    val titleNews: String,
    val descriptionNews: String,
)

