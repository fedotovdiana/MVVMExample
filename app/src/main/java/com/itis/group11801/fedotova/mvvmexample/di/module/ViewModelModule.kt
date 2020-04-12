package com.itis.group11801.fedotova.mvvmexample.di.module

import androidx.lifecycle.ViewModelProvider
import com.itis.group11801.fedotova.mvvmexample.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
