package com.practice.mygiphyapp.network.response

import com.google.gson.annotations.SerializedName

class Images {
    @SerializedName("fixed_width")
    var fixedWidth:FixedWidthImage ?= null
}