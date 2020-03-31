package com.itis.group11801.fedotova.mvvmexample.view

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.itis.group11801.fedotova.mvvmexample.R
import com.itis.group11801.fedotova.mvvmexample.databinding.ActivityMainBinding
import com.itis.group11801.fedotova.mvvmexample.di.injectViewModel
import com.itis.group11801.fedotova.mvvmexample.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override fun layoutResource(): Int {
        return R.layout.activity_main
    }

    override fun inject() {
        viewModel = injectViewModel(viewModelFactory)
    }

    override fun subscribe() {
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
}
