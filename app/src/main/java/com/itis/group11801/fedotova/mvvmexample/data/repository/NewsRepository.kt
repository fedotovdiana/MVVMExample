package com.itis.group11801.fedotova.mvvmexample.data.repository

import com.itis.group11801.fedotova.mvvmexample.data.model.News
import io.reactivex.Single

interface NewsRepository {

    fun getNews(): Single<List<News>>
}
