package com.itis.group11801.fedotova.mvvmexample.di.module

import androidx.lifecycle.ViewModel
import com.itis.group11801.fedotova.mvvmexample.di.ViewModelKey
import com.itis.group11801.fedotova.mvvmexample.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        ViewModelModule::class
    ]
)
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindNewsViewModel(viewModel: MainViewModel): ViewModel
}
