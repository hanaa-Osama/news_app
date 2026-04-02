package com.example.news_app.domain.repository

import com.example.news_app.domain.model.NewsModel

interface NewsRepo {
    suspend fun getNews() : List<NewsModel>
}