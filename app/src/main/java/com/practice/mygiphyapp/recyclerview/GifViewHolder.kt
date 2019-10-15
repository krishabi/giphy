package com.practice.mygiphyapp.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.mygiphyapp.network.response.FixedWidthImage
import kotlinx.android.synthetic.main.layout_item.view.*

class GifViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    fun bindView(fixedWidthImage: FixedWidthImage){

        Glide.with(itemView.context).load(fixedWidthImage.webp).into(itemView.imageGif)
    }
}