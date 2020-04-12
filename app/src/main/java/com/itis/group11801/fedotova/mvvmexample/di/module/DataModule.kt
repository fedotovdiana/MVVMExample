package com.itis.group11801.fedotova.mvvmexample.di.module

import com.itis.group11801.fedotova.mvvmexample.data.repository.NewsRepository
import com.itis.group11801.fedotova.mvvmexample.data.repository.NewsRepositoryImpl
import com.itis.group11801.fedotova.mvvmexample.domain.NewsInteractor
import com.itis.group11801.fedotova.mvvmexample.domain.NewsInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideNewsRepository(userRepository: NewsRepositoryImpl): NewsRepository = userRepository

    @Provides
    @Singleton
    fun provideNewsInteractor(userInteractor: NewsInteractorImpl): NewsInteractor = userInteractor
}