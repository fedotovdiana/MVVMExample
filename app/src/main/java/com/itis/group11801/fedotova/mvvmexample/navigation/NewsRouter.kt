package com.itis.group11801.fedotova.mvvmexample.navigation

import android.content.Context

interface NewsRouter {

    fun openNews(context: Context, newsUrl: String)

}
