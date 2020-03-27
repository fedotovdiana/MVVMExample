package com.itis.group11801.fedotova.mvvmexample.view

import androidx.lifecycle.Observer
import com.itis.group11801.fedotova.mvvmexample.R
import com.itis.group11801.fedotova.mvvmexample.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override fun layoutResource(): Int {
        return R.layout.activity_main
    }

    override fun initViews() {

    }

    override fun subscribe(viewModel: MainViewModel) {
        viewModel.newsLiveData.observe(this, Observer { list ->
            if (rvNews.adapter == null) {
                rvNews.adapter = NewsAdapter { viewModel.newsClicked(this, it) }
            }
            (rvNews.adapter as NewsAdapter).submitList(list)
        })
        viewModel.getNews()
    }
}
