package com.itis.group11801.fedotova.mvvmexample


import android.app.Application
import com.itis.group11801.fedotova.mvvmexample.di.AppInjector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}
