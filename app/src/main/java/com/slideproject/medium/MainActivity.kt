package com.slideproject.medium

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class MainActivity : AppCompatActivity() {

    var mRecyclerView: RecyclerView? = null
    var swipeRefresh: SwipeRefreshLayout? = null
    private var mainViewModel: MainViewModel? = null
    var mBlogAdapter: BlogAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializationViews()

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        getPopularBlog()

        // lambda expression
        swipeRefresh!!.setOnRefreshListener { getPopularBlog() }
    }

    private fun initializationViews() {
        swipeRefresh = findViewById(R.id.swiperefresh)
        mRecyclerView = findViewById(R.id.blogRecyclerView)
    }

    private fun getPopularBlog() {
        swipeRefresh!!.isRefreshing = true
        mainViewModel?.allPublished
            ?.observe(this,
                Observer<List<Blog?>?> { blogList ->
                    swipeRefresh!!.isRefreshing = false
                    prepareRecyclerView(blogList as List<Blog>)
                })
    }

    private fun prepareRecyclerView(blogList: List<Blog>) {
        mBlogAdapter = BlogAdapter(blogList)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        } else {
            mRecyclerView!!.layoutManager = GridLayoutManager(this, 4)
        }

        mRecyclerView!!.itemAnimator = DefaultItemAnimator()
        mRecyclerView!!.adapter = mBlogAdapter
        mBlogAdapter!!.notifyDataSetChanged()
    }
}
