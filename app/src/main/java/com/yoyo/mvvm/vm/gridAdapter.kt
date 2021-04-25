package com.yoyo.mvvm.vm

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.lifecycle.MutableLiveData
import com.yoyo.mvvm.R
import com.yoyo.mvvm.repository.Result
import kotlinx.android.synthetic.main.movie_card.view.*


class gridAdapter: BaseAdapter() {
    var results : List<Result> = emptyList()



    override fun getCount(): Int {
        return 25
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {



        var view :View = View.inflate(parent?.context, R.layout.movie_card, null)

        if(results.isEmpty() == false) {
            view.cv_movie_title.text = results[position].title.toString()
        }
        return view
    }

    fun setList(moviesList: List<Result?>) {
        results = moviesList as List<Result>

    }
}