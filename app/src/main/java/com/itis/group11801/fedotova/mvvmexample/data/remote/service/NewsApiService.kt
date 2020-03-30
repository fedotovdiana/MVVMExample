package com.itis.group11801.fedotova.mvvmexample.data.remote.service

import com.itis.group11801.fedotova.mvvmexample.BuildConfig
import com.itis.group11801.fedotova.mvvmexample.data.remote.model.ResultResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    fun getAllNews(
        @Query("country") country: String = "us",
        @Query("category") category: String = "general",
        @Query("apiKey") api: String = BuildConfig.API_KEY
    ): Single<ResultResponse>
}
