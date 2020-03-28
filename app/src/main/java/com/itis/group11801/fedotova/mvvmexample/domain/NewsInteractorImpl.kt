package com.itis.group11801.fedotova.mvvmexample.domain

import com.itis.group11801.fedotova.mvvmexample.data.model.News
import com.itis.group11801.fedotova.mvvmexample.data.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject

class NewsInteractorImpl @Inject constructor(
    private val newsRepository: NewsRepository
) : NewsInteractor {

    override fun getNews(): Single<List<News>> {
        return newsRepository.getNews()
    }
}
