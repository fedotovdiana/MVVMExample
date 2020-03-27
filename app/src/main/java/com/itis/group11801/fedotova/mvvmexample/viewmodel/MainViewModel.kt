package com.itis.group11801.fedotova.mvvmexample.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itis.group11801.fedotova.mvvmexample.data.ApiFactory
import com.itis.group11801.fedotova.mvvmexample.data.model.News
import com.itis.group11801.fedotova.mvvmexample.data.model.ResultResponse
import com.itis.group11801.fedotova.mvvmexample.domain.NewsInteractorImpl
import com.itis.group11801.fedotova.mvvmexample.navigation.NewsRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val interactor: NewsInteractorImpl,
    private val router: NewsRouter
) : BaseViewModel() {

    private val _newsLiveData = MutableLiveData<List<News>>()
    val newsLiveData: LiveData<List<News>> = _newsLiveData

    fun newsClicked(context: Context, news: News) {
        router.openNews(context, news.title!!)
    }

    fun getNews() {
        disposables.add(
            interactor.getNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _newsLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }
}
