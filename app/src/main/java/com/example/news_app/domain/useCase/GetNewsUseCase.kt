package com.example.news_app.domain.useCase

import com.example.news_app.domain.model.NewsModel
import com.example.news_app.domain.repository.NewsRepo
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepo: NewsRepo
) {
    suspend operator fun invoke(): List<NewsModel>{
        return newsRepo.getNews()
    }
}