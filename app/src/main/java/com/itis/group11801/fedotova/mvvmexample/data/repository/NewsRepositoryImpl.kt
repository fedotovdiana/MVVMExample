package com.itis.group11801.fedotova.mvvmexample.data.repository

import com.itis.group11801.fedotova.mvvmexample.data.local.NewsDao
import com.itis.group11801.fedotova.mvvmexample.data.remote.mapper.mapNewsLocalToNews
import com.itis.group11801.fedotova.mvvmexample.data.remote.mapper.mapNewsToNewsLocal
import com.itis.group11801.fedotova.mvvmexample.data.remote.mapper.mapResponseResultToNews
import com.itis.group11801.fedotova.mvvmexample.data.remote.service.NewsApiService
import com.itis.group11801.fedotova.mvvmexample.domain.model.News
import io.reactivex.Single
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val service: NewsApiService,
    private val newsDao: NewsDao
) : NewsRepository {

    override fun getNews(): Single<List<News>> {
        return service.getAllNews()
            .map { result ->
                result.newsResponse.map {
                    mapResponseResultToNews(it)
                }
            }.doOnSuccess { list ->
                list.map {
                    newsDao.insert(mapNewsToNewsLocal(it))
                }
            }
    }

    override fun getConcreteNews(url: String): Single<News> {
        return newsDao.getNews(url).map {
            mapNewsLocalToNews(it)
        }
    }
}
