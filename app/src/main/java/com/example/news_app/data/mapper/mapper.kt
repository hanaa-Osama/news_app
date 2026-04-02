package com.example.news_app.data.mapper

import com.example.news_app.data.dataSource.local.NewsEntity
import com.example.news_app.data.model.NewsDto
import com.example.news_app.domain.model.NewsModel

fun NewsDto.toDomain() = NewsModel(
    id = idNews,
    title = titleNews,
    description = descriptionNews
)

fun NewsEntity.toDomain() = NewsModel(
    id = id,
    title = title,
    description = description
)


