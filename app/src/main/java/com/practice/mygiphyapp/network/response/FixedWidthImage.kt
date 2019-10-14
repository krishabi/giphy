package com.practice.mygiphyapp.network.response

import com.google.gson.annotations.SerializedName

class FixedWidthImage {
    @SerializedName("height")
    var height:String ?= null
    @SerializedName("width")
    var width:String ?= null
    @SerializedName("webp")
    var webp:String ?= null
}