package com.practice.mygiphyapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.practice.mygiphyapp.network.RetrofitClient
import com.practice.mygiphyapp.network.request.GiphyApi
import com.practice.mygiphyapp.network.response.DataItem
import com.practice.mygiphyapp.network.response.GifResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GifRepository {

    var gifList = MutableLiveData<ArrayList<DataItem>>()
    private var gifRepository : GifRepository?= null
    private val apiKey: String = "xUzgeEEG5dno2RIjckzRPyeGBUK3Ezvt"
    private val rating: String = "g"
    private val lang: String="en"

    fun getInstance(): GifRepository {
        if (gifRepository == null) {
            gifRepository = GifRepository()
        }
        return gifRepository!!
    }

    fun getGif(offSet:Int,query:String):MutableLiveData<ArrayList<DataItem>>{

        var giphyApi = RetrofitClient.instance.create(GiphyApi::class.java)
        var responseCall = giphyApi.fetchGifs(apiKey,query,25,offSet,rating,lang)
        responseCall.enqueue(object :Callback<GifResponse>{
            override fun onFailure(call: Call<GifResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<GifResponse>, response: Response<GifResponse>) {
                    if (response?.body() != null) {
                        gifList.value = response?.body()?.data
                        Log.e("Abishek", response?.body()?.data?.get(0)?.title)
                    } else {
                    Log.e("Abishek", response?.errorBody()?.string()+"    "+call.request())
                }
            }
        } )
        return gifList;
    }

}