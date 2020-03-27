package com.itis.group11801.fedotova.mvvmexample.data.service

import com.itis.group11801.fedotova.mvvmexample.BuildConfig
import com.itis.group11801.fedotova.mvvmexample.data.model.ResultResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    fun getAllNews(
        @Query("country") country: String = "ru",
//        @Query("category") category: String = "health",
        @Query("apiKey") api: String = BuildConfig.API_KEY
    ): Single<ResultResponse>
}
// http://newsapi.org/v2/top-headlines?country=us&category=health&apiKey=39ca608664a741e390df7aabf5b0e7c5
