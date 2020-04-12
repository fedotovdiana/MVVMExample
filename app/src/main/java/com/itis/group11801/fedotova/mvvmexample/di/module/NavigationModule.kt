package com.itis.group11801.fedotova.mvvmexample.di.module

import com.itis.group11801.fedotova.mvvmexample.navigation.Navigator
import com.itis.group11801.fedotova.mvvmexample.navigation.NewsRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun provideNavigator(): Navigator = Navigator()

    @Provides
    @Singleton
    fun provideNewsRouter(navigator: Navigator): NewsRouter = navigator
}
