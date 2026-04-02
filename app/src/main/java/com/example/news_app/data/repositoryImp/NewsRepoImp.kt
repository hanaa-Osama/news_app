package com.example.news_app.data.repositoryImp

import com.example.news_app.data.dataSource.local.NewsDao
import com.example.news_app.data.dataSource.remote.NewsAPIService
import com.example.news_app.data.mapper.toDomain
import com.example.news_app.domain.model.NewsModel
import com.example.news_app.domain.repository.NewsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepoImp @Inject constructor(
    private val apiService: NewsAPIService,
    private val newsDao: NewsDao
): NewsRepo {
    override suspend fun getNews(): List<NewsModel> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getNews()
            response.articles.map { it.toDomain() }
        } catch (e: Exception) {
            newsDao.getNews().map { it.toDomain() }
        }
    }
}
