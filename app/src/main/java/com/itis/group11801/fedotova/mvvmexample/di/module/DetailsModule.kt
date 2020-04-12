package com.itis.group11801.fedotova.mvvmexample.di.module

import androidx.lifecycle.ViewModel
import com.itis.group11801.fedotova.mvvmexample.di.ViewModelKey
import com.itis.group11801.fedotova.mvvmexample.viewmodel.DetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel
}
