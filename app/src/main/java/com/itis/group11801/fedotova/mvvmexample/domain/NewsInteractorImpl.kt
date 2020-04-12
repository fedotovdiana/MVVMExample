package com.itis.group11801.fedotova.mvvmexample.domain

import com.itis.group11801.fedotova.mvvmexample.data.repository.NewsRepository
import com.itis.group11801.fedotova.mvvmexample.domain.model.News
import io.reactivex.Single
import javax.inject.Inject

class NewsInteractorImpl @Inject constructor(
    private val newsRepository: NewsRepository
) : NewsInteractor {

    override fun getNews(): Single<List<News>> {
        return newsRepository.getNews()
    }

    override fun getConcreteNews(url: String): Single<News> {
        return newsRepository.getConcreteNews(url)
    }
}
