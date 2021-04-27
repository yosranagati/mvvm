package com.yoyo.mvvm.view.singleMovieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoyo.mvvm.data.api.PostClient
import com.yoyo.mvvm.repository.singleMovieDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class singleMovieViewModel : ViewModel() {
    val movieDetails = MutableLiveData<singleMovieDetails>()

    fun getMovieDetails(id: Int?){

        println("mv $id")
        val retrofit = PostClient.getClient()

        val call = retrofit.getMovieDetails(id , PostClient.AppId)




        call.enqueue(object : Callback<singleMovieDetails> {
            override fun onResponse(
                call: Call<singleMovieDetails>,
                response: Response<singleMovieDetails>
            ) {
                println(response.body())
                movieDetails.value = response.body()
            }

            override fun onFailure(call: Call<singleMovieDetails>, t: Throwable) {
                println(t.message)
            }


        })












    }
}


