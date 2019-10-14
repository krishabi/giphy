package com.practice.mygiphyapp.network.request

import com.practice.mygiphyapp.network.response.GifResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    @GET("search")
    fun fetchGifs(@Query("api_key") apiKey:String,@Query("q") q:String, @Query("limit") limit:Int, @Query("offset") offSet:Int, @Query("rating") rating:String, @Query("lang") lang:String): Call<GifResponse>
}