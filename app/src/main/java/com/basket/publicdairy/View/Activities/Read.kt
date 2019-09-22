package com.basket.publicdairy.View.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.basket.publicdairy.R


class Read : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        val tarih=intent.getStringExtra("tarih")
        val yazi=intent.getStringExtra("yazi")
    }
}
