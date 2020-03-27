package com.itis.group11801.fedotova.mvvmexample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itis.group11801.fedotova.mvvmexample.viewmodel.BaseViewModel

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    protected open lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutResource())
        initViews()
        subscribe(viewModel)
    }

    abstract fun layoutResource(): Int

    abstract fun initViews()

    abstract fun subscribe(viewModel: T)
}