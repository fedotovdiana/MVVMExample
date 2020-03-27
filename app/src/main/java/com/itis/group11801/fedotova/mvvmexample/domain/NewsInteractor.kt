package com.itis.group11801.fedotova.mvvmexample.domain

import com.itis.group11801.fedotova.mvvmexample.data.model.News
import io.reactivex.Single

interface NewsInteractor {

    fun getNews(): Single<List<News>>
}