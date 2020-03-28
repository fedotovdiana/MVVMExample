package com.itis.group11801.fedotova.mvvmexample.di.module

import com.itis.group11801.fedotova.mvvmexample.navigation.Navigator
import com.itis.group11801.fedotova.mvvmexample.navigation.NewsRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @Singleton
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @Singleton
    @Provides
    fun provideNewsRouter(navigator: Navigator): NewsRouter = navigator
}
