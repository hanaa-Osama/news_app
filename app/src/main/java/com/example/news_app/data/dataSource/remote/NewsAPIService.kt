package com.example.news_app.data.dataSource.remote

import com.example.news_app.Utils.Constance.API_KEY
import com.example.news_app.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") query: String = "مصر",
        @Query("language") language: String = "ar",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}
