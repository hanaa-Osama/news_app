package com.example.news_app.data.dataSource.local

import androidx.room.Dao
import androidx.room.Query

@Dao
interface NewsDao {
    @Query("SELECT * FROM news_table")
    suspend fun getNews(): List<NewsEntity>
}