package com.itis.group11801.fedotova.mvvmexample.data.repository

import com.itis.group11801.fedotova.mvvmexample.domain.model.News
import io.reactivex.Single

interface NewsRepository {

    fun getNews(): Single<List<News>>

    fun getConcreteNews(url: String): Single<News>
}
