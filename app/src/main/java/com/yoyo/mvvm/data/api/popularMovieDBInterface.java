package com.yoyo.mvvm.data.api;

import com.yoyo.mvvm.repository.MovieDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface popularMovieDBInterface {


    @GET("movie/popular?")

    public Call<MovieDetails> getPost(@Query("api_key") String userApiKey);


  // public Call<List<MovieDetails>> getPost(@Query("api_key") String userApiKey);


  // fun getPost(@Query("api_key") userApiKey: String): Call<List<MovieDetails>>




}
