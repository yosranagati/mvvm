package com.yoyo.mvvm.data.api
import androidx.lifecycle.ViewModel
import com.yoyo.mvvm.repository.MovieDetails
import com.yoyo.mvvm.repository.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object  PostClient {


    var BaseUrl = "https://api.themoviedb.org/3/"
    var AppId = "2376e4c6e95d883b82d31e2a21d09c1e"
    val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
    var moviesList : List<Result> = emptyList()


    fun getClient(): popularMovieDBInterface {

       val retrofit = Retrofit.Builder()
           .baseUrl(BaseUrl)
           .addConverterFactory(GsonConverterFactory.create())
           .build()


       val service = retrofit.create(popularMovieDBInterface::class.java)





        return service

   }




}