package com.practice.mygiphyapp.network.response

import com.google.gson.annotations.SerializedName

 class GifResponse(

    @SerializedName("data")
    var data : ArrayList<DataItem> ?= null


)