package com.itis.group11801.fedotova.mvvmexample.domain

import com.itis.group11801.fedotova.mvvmexample.domain.model.News
import io.reactivex.Single

interface NewsInteractor {

    fun getNews(): Single<List<News>>

    fun getConcreteNews(url: String): Single<News>
}
