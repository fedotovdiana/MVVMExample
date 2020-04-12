package com.itis.group11801.fedotova.mvvmexample.di.component

import android.app.Application
import com.itis.group11801.fedotova.mvvmexample.App
import com.itis.group11801.fedotova.mvvmexample.di.module.DataModule
import com.itis.group11801.fedotova.mvvmexample.di.module.DbModule
import com.itis.group11801.fedotova.mvvmexample.di.module.NavigationModule
import com.itis.group11801.fedotova.mvvmexample.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class,
        DataModule::class,
        NetworkModule::class,
        NavigationModule::class
    ]
)
interface AppComponent {

    fun plusMainComponentBuilder(): MainComponent.Builder

    fun plusDetailsComponentBuilder(): DetailsComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}
