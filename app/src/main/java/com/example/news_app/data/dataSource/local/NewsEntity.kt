package com.example.news_app.data.dataSource.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")

data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String
)