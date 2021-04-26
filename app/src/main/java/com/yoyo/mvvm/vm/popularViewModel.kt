package com.yoyo.mvvm.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoyo.mvvm.data.api.PostClient
import com.yoyo.mvvm.repository.MovieDetails
import com.yoyo.mvvm.repository.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class popularViewModel : ViewModel() {

    val moviesData = MutableLiveData<List<Result>>()

    fun fetchMovies(){

        val retrofit = PostClient.getClient()

        val call = retrofit.getPost(PostClient.AppId)




        call.enqueue(object : Callback<MovieDetails> {

            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                println(response.body()?.results)

               moviesData.value = response.body()?.results




            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                println(t.message)

            }

        })










    }
}



