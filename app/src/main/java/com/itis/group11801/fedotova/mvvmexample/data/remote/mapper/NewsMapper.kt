package com.itis.group11801.fedotova.mvvmexample.data.remote.mapper

import com.itis.group11801.fedotova.mvvmexample.data.local.NewsLocal
import com.itis.group11801.fedotova.mvvmexample.data.remote.model.NewsResponse
import com.itis.group11801.fedotova.mvvmexample.domain.model.News

fun mapResponseResultToNews(response: NewsResponse): News {
    return with(response) {
        News(
            source?.name ?: "",
            author ?: "",
            title ?: "",
            description ?: "",
            url ?: "",
            urlToImage ?: "",
            publishedAt ?: "",
            content ?: ""
        )
    }
}

fun mapNewsLocalToNews(newsLocal: NewsLocal): News {
    return with(newsLocal) {
        News(
            source,
            author,
            title,
            description,
            url,
            urlToImage,
            publishedAt,
            content
        )
    }
}

fun mapNewsToNewsLocal(news: News): NewsLocal {
    return with(news) {
        NewsLocal(
            0,
            source,
            author,
            title,
            description,
            url,
            urlToImage,
            publishedAt,
            content
        )
    }
}
