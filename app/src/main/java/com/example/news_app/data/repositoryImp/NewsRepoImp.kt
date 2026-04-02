package com.example.news_app.data.repositoryImp

import com.example.news_app.data.dataSource.local.NewsDao
import com.example.news_app.data.dataSource.remote.NewsAPIService
import com.example.news_app.data.mapper.toDomain
import com.example.news_app.domain.model.NewsModel
import com.example.news_app.domain.repository.NewsRepo
import javax.inject.Inject

class NewsRepoImp @Inject constructor(
    val apiService: NewsAPIService,
    val newsDao: NewsDao
): NewsRepo {
    override suspend fun getNews(): List<NewsModel> {
        return try {
            val response = apiService.getNews()
            val remoteNews = response.articles
            remoteNews.map { it.toDomain()}

        }catch (e: Exception){
            newsDao.getNews().map { it.toDomain()}
        }
    }

}