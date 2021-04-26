package com.yoyo.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
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
        viewModel.fetchMovies()
        viewModel.moviesData.observe(this , Observer {
           println("observer find something new")
           gridViewAdapter.setList(it)
           gridViewAdapter.notifyDataSetChanged()






        })


//        grid_view.setOnItemClickListener { parent, view, position, id ->
//            println(position)}


//        grid_view.onItemClickListener = (object : AdapterView.OnItemClickListener{
//
//            override fun onItemClick(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//               Toast.makeText(applicationContext , "Index $position", Toast.LENGTH_LONG).show()
//
//                println(position)
//            }
//
//        })

//        grid_view.onItemClickListener = (AdapterView.OnItemClickListener { parent, view, position, id ->
//            //Toast.makeText(applicationContext , "Index $position", Toast.LENGTH_LONG).show()
//
//            println(position)
//        })


//        grid_view.setOnItemClickListener{ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
//
//
//            Toast.makeText(applicationContext , "Index $i", Toast.LENGTH_LONG).show()
//            println(i)
//        }











    }









}














