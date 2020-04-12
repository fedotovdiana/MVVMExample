package com.itis.group11801.fedotova.mvvmexample.di

import com.itis.group11801.fedotova.mvvmexample.App
import com.itis.group11801.fedotova.mvvmexample.di.component.AppComponent
import com.itis.group11801.fedotova.mvvmexample.di.component.DaggerAppComponent
import com.itis.group11801.fedotova.mvvmexample.di.component.DetailsComponent
import com.itis.group11801.fedotova.mvvmexample.di.component.MainComponent
import com.itis.group11801.fedotova.mvvmexample.view.DetailsActivity
import com.itis.group11801.fedotova.mvvmexample.view.MainActivity

object AppInjector {

    lateinit var appComponent: AppComponent
    private var mainComponent: MainComponent? = null
    private var detailsComponent: DetailsComponent? = null

    fun init(application: App) {
        DaggerAppComponent
            .builder()
            .application(application)
            .build().also { appComponent = it }
            .inject(application)
    }

    fun injectMainActivity(activity: MainActivity) {
        mainComponent?.inject(activity)
    }

    fun injectDetailsActivity(activity: DetailsActivity) {
        detailsComponent?.inject(activity)
    }

    fun initMainComponent() {
        mainComponent ?: appComponent
            .plusMainComponentBuilder()
            .build()
            .also {
                mainComponent = it
            }
    }

    fun initDetailsComponent() {
        detailsComponent ?: appComponent
            .plusDetailsComponentBuilder()
            .build()
            .also {
                detailsComponent = it
            }
    }

    fun clearMainComponent() {
        mainComponent = null
    }

    fun clearDetailsComponent() {
        detailsComponent = null
    }

}
