package com.example.news_app.data.dataSource.remote

import com.example.news_app.data.model.NewsResponse

interface NewsAPIService {
    suspend fun getNews(): NewsResponse
}