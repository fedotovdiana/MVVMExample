package com.itis.group11801.fedotova.mvvmexample.di.module

import androidx.lifecycle.ViewModelProvider
import com.itis.group11801.fedotova.mvvmexample.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
