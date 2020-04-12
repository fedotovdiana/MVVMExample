package com.itis.group11801.fedotova.mvvmexample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.itis.group11801.fedotova.mvvmexample.R
import com.itis.group11801.fedotova.mvvmexample.databinding.ActivityMainBinding
import com.itis.group11801.fedotova.mvvmexample.di.AppInjector
import com.itis.group11801.fedotova.mvvmexample.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AppInjector.initMainComponent()
        AppInjector.injectMainActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        subscribe()
    }

    private fun subscribe() {
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.newsLiveData.observe(this, Observer { list ->
            if (binding.rvNews.adapter == null) {
                binding.rvNews.adapter = NewsAdapter { viewModel.newsClicked(this, it.url) }
            }
            (binding.rvNews.adapter as NewsAdapter).submitList(list)
        })
        viewModel.getNews()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearMainComponent()
    }
}
