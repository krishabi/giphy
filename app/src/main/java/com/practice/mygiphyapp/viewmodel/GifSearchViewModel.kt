package com.practice.mygiphyapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.practice.mygiphyapp.network.response.DataItem
import com.practice.mygiphyapp.repo.GifRepository


class GifSearchViewModel(application: Application) : AndroidViewModel(application){

    private val searchText = MutableLiveData<String>()
    val gifListObservable:LiveData<ArrayList<DataItem>> = Transformations.switchMap(searchText, ::loadGifsWithQuery)

     private fun loadGifsWithQuery(query:String) = GifRepository().getInstance().getGif(0,query)

    fun searchByQuery(query:String) =apply { searchText.value = query }


}


