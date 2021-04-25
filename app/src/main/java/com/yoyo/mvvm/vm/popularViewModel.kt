package com.yoyo.mvvm.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoyo.mvvm.data.api.PostClient
import com.yoyo.mvvm.repository.Result

class popularViewModel : ViewModel() {

    val moviesData = MutableLiveData<List<Result>>()

    fun fetchMovies(){

        val retrofitList = PostClient.getClient()




        println(retrofitList)
        if(retrofitList?.isEmpty() == false){
            println(retrofitList[0])
            moviesData.value = retrofitList!!
        }





    }
}

