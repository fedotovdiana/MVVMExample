package com.itis.group11801.fedotova.mvvmexample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.itis.group11801.fedotova.mvvmexample.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    protected open lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutResource())
        inject()
        subscribe()
    }

    abstract fun layoutResource(): Int

    abstract fun inject()

    abstract fun subscribe()
}