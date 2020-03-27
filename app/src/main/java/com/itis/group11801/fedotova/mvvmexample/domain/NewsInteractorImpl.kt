package com.itis.group11801.fedotova.mvvmexample.domain

import com.itis.group11801.fedotova.mvvmexample.data.repository.NewsRepository
import com.itis.group11801.fedotova.mvvmexample.data.model.News
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class NewsInteractorImpl(
    private val newsRepository: NewsRepository
) : NewsInteractor {

    override fun getNews(): Single<List<News>> {
        return newsRepository.getNews()
            .subscribeOn(Schedulers.io())
    }
}
