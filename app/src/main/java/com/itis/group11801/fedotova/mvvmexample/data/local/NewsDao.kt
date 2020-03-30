package com.itis.group11801.fedotova.mvvmexample.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getNews(): Single<List<NewsLocal>>

    @Query("SELECT * FROM news WHERE url = :url")
    fun getNews(url: String): Single<NewsLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(news: NewsLocal)
}
