package com.itis.group11801.fedotova.mvvmexample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itis.group11801.fedotova.mvvmexample.di.ViewModelKey
import com.itis.group11801.fedotova.mvvmexample.viewmodel.DetailsViewModel
import com.itis.group11801.fedotova.mvvmexample.viewmodel.MainViewModel
import com.itis.group11801.fedotova.mvvmexample.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindNewsViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
