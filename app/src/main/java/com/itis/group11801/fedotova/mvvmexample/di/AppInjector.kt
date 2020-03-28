package com.itis.group11801.fedotova.mvvmexample.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.itis.group11801.fedotova.mvvmexample.App
import com.itis.group11801.fedotova.mvvmexample.di.component.DaggerAppComponent
import dagger.android.AndroidInjection

object AppInjector {

    fun init(application: App) {
        DaggerAppComponent
            .builder()
            .application(application)
            .build()
            .inject(application)

        application
            .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    AndroidInjection.inject(activity)
                }

                override fun onActivityStarted(activity: Activity) {

                }

                override fun onActivityResumed(activity: Activity) {

                }

                override fun onActivityPaused(activity: Activity) {

                }

                override fun onActivityStopped(activity: Activity) {

                }

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

                }

                override fun onActivityDestroyed(activity: Activity) {

                }
            })
    }
}
