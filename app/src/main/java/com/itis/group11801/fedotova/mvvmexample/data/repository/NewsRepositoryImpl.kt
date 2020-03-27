package com.itis.group11801.fedotova.mvvmexample.data.repository

import com.itis.group11801.fedotova.mvvmexample.data.ApiFactory
import com.itis.group11801.fedotova.mvvmexample.data.mapper.mapResponseResultToNews
import com.itis.group11801.fedotova.mvvmexample.data.model.News
import com.itis.group11801.fedotova.mvvmexample.data.service.NewsApiService
import io.reactivex.Single

class NewsRepositoryImpl(
    private val service: NewsApiService = ApiFactory.newsService
) : NewsRepository {

    override fun getNews(): Single<List<News>> {
        return service.getAllNews()
            .map { result ->  mapResponseResultToNews(result.newsResponse) }
    }
}