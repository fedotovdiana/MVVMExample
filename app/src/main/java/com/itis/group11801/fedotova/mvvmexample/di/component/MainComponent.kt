package com.itis.group11801.fedotova.mvvmexample.di.component

import com.itis.group11801.fedotova.mvvmexample.di.module.MainModule
import com.itis.group11801.fedotova.mvvmexample.di.scope.ActivityScope
import com.itis.group11801.fedotova.mvvmexample.view.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Builder {
        fun build(): MainComponent
    }

    fun inject(activity: MainActivity)
}