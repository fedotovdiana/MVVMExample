package com.itis.group11801.fedotova.mvvmexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itis.group11801.fedotova.mvvmexample.domain.NewsInteractor
import com.itis.group11801.fedotova.mvvmexample.domain.model.News
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val interactor: NewsInteractor
) : BaseViewModel() {

    private val _newsLiveData = MutableLiveData<News>()
    val newsLiveData: LiveData<News>
        get() = _newsLiveData

    fun getConcreteNews(url: String) {
        disposables.add(
            interactor.getConcreteNews(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _newsLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }
}
