package com.itis.group11801.fedotova.mvvmexample.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val source: String,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
