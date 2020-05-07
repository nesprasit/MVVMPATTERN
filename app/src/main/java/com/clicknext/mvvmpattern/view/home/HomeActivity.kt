package com.clicknext.mvvmpattern.view.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.clicknext.mvvmpattern.R
import com.clicknext.mvvmpattern.view.base.BaseActivity
import com.clicknext.mvvmpattern.view.home.adapter.HomeAdapter
import com.clicknext.mvvmpattern.viewmode.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(){
    private val tag = this::class.java.simpleName

    private lateinit var viewMode: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewMode = ViewModelProvider(this).get(HomeViewModel::class.java)

        init()
        initEvent()
    }

    private fun init() {
        photo_list.setHasFixedSize(true)
        val manager = GridLayoutManager(this,4)
        photo_list.layoutManager = manager
    }

    private fun initEvent() {

        viewMode.getPhoto("1","30").observe(this, Observer {
            val adapter = HomeAdapter(it)
            photo_list.adapter = adapter
        })

    }
}












