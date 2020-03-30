package com.itis.group11801.fedotova.mvvmexample.navigation

import android.content.Context
import android.content.Intent
import com.itis.group11801.fedotova.mvvmexample.view.DetailsActivity

class Navigator : NewsRouter {

    override fun openNews(context: Context, newsUrl: String) {

        val intent = Intent(context, DetailsActivity::class.java).apply {
            putExtra(KEY_NEWS, newsUrl)
        }
        context.startActivity(intent)
    }

    companion object {
        const val KEY_NEWS = "news_url"
    }
}
