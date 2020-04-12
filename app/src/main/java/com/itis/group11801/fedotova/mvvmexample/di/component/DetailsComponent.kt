package com.itis.group11801.fedotova.mvvmexample.di.component

import com.itis.group11801.fedotova.mvvmexample.di.module.DetailsModule
import com.itis.group11801.fedotova.mvvmexample.di.scope.ActivityScope
import com.itis.group11801.fedotova.mvvmexample.view.DetailsActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [DetailsModule::class])
interface DetailsComponent {

    @Subcomponent.Factory
    interface Builder {
        fun build(): DetailsComponent
    }

    fun inject(activity: DetailsActivity)
}
