package com.yoyo.mvvm.view.singleMovieDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.yoyo.mvvm.R
import com.yoyo.mvvm.data.api.PostClient
import com.yoyo.mvvm.repository.singleMovieDetails
import kotlinx.android.synthetic.main.activity_single_movie.*
import java.text.NumberFormat
import java.util.*

class SingleMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_movie)


        var data = intent.extras?.getInt("id")
        println("sending id $data")

        val model = singleMovieViewModel()
        model.getMovieDetails(data)
            model.movieDetails.observe(this , Observer {
                println("alot of Details $it")
                bindUI(it)


            })



    }

    fun bindUI( it:singleMovieDetails ){
        movie_title.text = it.title


        movie_tagline.text = it.tagline
        movie_release_date.text = it.release_date
        movie_rating.text = it.vote_average.toString()
        movie_runtime.text = it.runtime.toString() + " minutes"
        movie_overview.text = it.overview
//
        val formatCurrency = NumberFormat.getCurrencyInstance(Locale.US)
        movie_budget.text = formatCurrency.format(it.budget)
        movie_revenue.text = formatCurrency.format(it.revenue)
//
        val moviePosterURL = PostClient.POSTER_BASE_URL + it.poster_path
        Glide.with(this)
            .load(moviePosterURL)
            .into(iv_movie_poster);


    }
}