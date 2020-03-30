package com.itis.group11801.fedotova.mvvmexample.di.module

import com.itis.group11801.fedotova.mvvmexample.view.DetailsActivity
import com.itis.group11801.fedotova.mvvmexample.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailsActivity(): DetailsActivity
}