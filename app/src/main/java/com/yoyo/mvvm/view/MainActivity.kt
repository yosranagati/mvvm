package com.yoyo.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yoyo.mvvm.R
import com.yoyo.mvvm.data.api.PostClient
import com.yoyo.mvvm.vm.gridAdapter
import com.yoyo.mvvm.vm.popularViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:popularViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var gridViewAdapter = gridAdapter()
        grid_view.adapter = gridViewAdapter
        viewModel = ViewModelProvider(this).get(popularViewModel :: class.java)

       viewModel.moviesData.observe(this , Observer {
           println("observer find something new")
           gridViewAdapter.setList(it)
           gridViewAdapter.notifyDataSetChanged()

//
        })
        viewModel.fetchMovies()
//        )




        //grid_view.adapter = gridAdapter()


    }









}










