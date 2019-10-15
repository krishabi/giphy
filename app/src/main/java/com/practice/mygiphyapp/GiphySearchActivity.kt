package com.practice.mygiphyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity



class GiphySearchActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giphy)

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val arguments = Bundle()
            val fragment = GiphySearchFragment.newInstance()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                .add(R.id.gif_list, fragment)
                .addToBackStack(null)
                .commit()
        }
    }


}

