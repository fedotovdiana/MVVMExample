package com.itis.group11801.fedotova.mvvmexample.data.mapper

import com.itis.group11801.fedotova.mvvmexample.data.model.News
import com.itis.group11801.fedotova.mvvmexample.data.model.NewsResponse

fun mapResponseResultToNews(response: List<NewsResponse>): List<News> {
    val newsList = mutableListOf<News>()
    for (resp in response) {
        with(resp) {
            newsList.add(
                News(
                    source?.name,
                    author,
                    title,
                    description,
                    url,
                    urlToImage,
                    publishedAt,
                    content
                )
            )
        }
    }
    return newsList
}
