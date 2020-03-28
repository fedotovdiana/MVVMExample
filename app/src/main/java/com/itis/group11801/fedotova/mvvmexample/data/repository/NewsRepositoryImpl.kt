package com.itis.group11801.fedotova.mvvmexample.data.repository

import com.itis.group11801.fedotova.mvvmexample.data.mapper.mapResponseResultToNews
import com.itis.group11801.fedotova.mvvmexample.data.model.News
import com.itis.group11801.fedotova.mvvmexample.data.service.NewsApiService
import io.reactivex.Single
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val service: NewsApiService
) : NewsRepository {

    override fun getNews(): Single<List<News>> {
        return service.getAllNews()
            .map { result -> mapResponseResultToNews(result.newsResponse) }
    }
}