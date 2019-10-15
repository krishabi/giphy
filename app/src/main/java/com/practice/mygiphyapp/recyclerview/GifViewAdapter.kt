package com.practice.mygiphyapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.mygiphyapp.R
import com.practice.mygiphyapp.network.response.DataItem

/*Recycler View Adapter*/
class GifViewAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var gifList = arrayListOf<DataItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GifViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = gifList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val gifViewHolder = holder as GifViewHolder
        gifViewHolder.bindView(gifList[position].images?.fixedWidth!!)
    }


    fun setGifList(listOfGifImage: ArrayList<DataItem>){
        this.gifList = listOfGifImage
        notifyDataSetChanged()
    }
}