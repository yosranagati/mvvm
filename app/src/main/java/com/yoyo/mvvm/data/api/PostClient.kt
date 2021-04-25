package com.yoyo.mvvm.data.api
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


    fun getClient(): List<Result>?{

       val retrofit = Retrofit.Builder()
           .baseUrl(BaseUrl)
           .addConverterFactory(GsonConverterFactory.create())
           .build()


       val service = retrofit.create(popularMovieDBInterface::class.java)


        val call = service.getPost(AppId)




        call.enqueue(object : Callback<MovieDetails> {

            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                println(response.body()?.results)
                moviesList = response.body()?.results!!

                println(moviesList)


            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                println(t.message)

            }

        })


        return moviesList

   }




}