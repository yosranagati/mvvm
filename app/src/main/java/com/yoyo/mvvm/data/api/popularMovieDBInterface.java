package com.yoyo.mvvm.data.api;

import com.yoyo.mvvm.repository.MovieDetails;
import com.yoyo.mvvm.repository.singleMovieDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface popularMovieDBInterface {


    @GET("movie/popular?")

    public Call<MovieDetails> getPost(@Query("api_key") String userApiKey);


    @GET("movie/{movie_id}")
    public  Call<singleMovieDetails> getMovieDetails(@Path("movie_id")  Integer id , @Query("api_key") String userApiKey);




}
