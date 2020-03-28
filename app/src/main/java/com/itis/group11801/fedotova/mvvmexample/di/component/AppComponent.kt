package com.itis.group11801.fedotova.mvvmexample.di.component

import android.app.Application
import com.itis.group11801.fedotova.mvvmexample.App
import com.itis.group11801.fedotova.mvvmexample.di.module.ActivityModule
import com.itis.group11801.fedotova.mvvmexample.di.module.AppModule
import com.itis.group11801.fedotova.mvvmexample.di.module.NavigationModule
import com.itis.group11801.fedotova.mvvmexample.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NavigationModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}