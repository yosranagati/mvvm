package com.yoyo.mvvm.vm

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.yoyo.mvvm.R
import com.yoyo.mvvm.data.api.PostClient
import com.yoyo.mvvm.repository.Result
import com.yoyo.mvvm.view.singleMovieDetails.SingleMovie
import kotlinx.android.synthetic.main.movie_card.view.*


class gridAdapter: BaseAdapter() {
    var results : List<Result> = emptyList()



    override fun getCount(): Int {
        return results.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view  = convertView


        view = View.inflate(parent?.context, R.layout.movie_card, null)


            if(results.isEmpty() == false ) {
                view.cv_movie_title.text = results[position].title.toString()
                view.cv_movie_release_date.text = results[position].release_date.toString()

                val moviePosterURL =  PostClient.POSTER_BASE_URL + results[position].poster_path

                Glide.with(view)
                    .load(moviePosterURL)
                    .into(view.cv_iv_movie_poster);
                view.setOnClickListener {

                    println("clicked $position")
                    val intent= Intent(parent?.context, SingleMovie::class.java)
//                    val intent = Intent(context, SingleMovie::class.java)
//                    intent.putExtra("id", movie?.id)
                    parent?.context?.startActivity(intent)

                }

            }






        return view
    }



    fun setList(moviesList: List<Result?>) {
        results = moviesList as List<Result>

    }


}