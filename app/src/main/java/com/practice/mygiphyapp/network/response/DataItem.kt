package com.practice.mygiphyapp.network.response

import com.google.gson.annotations.SerializedName

class DataItem {
    @SerializedName("types")
    var types:String ?= null
    @SerializedName("id")
    var id:String ?= null
    @SerializedName("url")
    var url:String ?= null
    @SerializedName("title")
    var title:String ?= null
    @SerializedName("images")
    var images:Images ?= null
}