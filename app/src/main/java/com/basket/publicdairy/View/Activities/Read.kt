package com.basket.publicdairy.View.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.basket.publicdairy.R


class Read : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        val gün:Long=intent.getLongExtra("gün",0)
        val yazi=intent.getStringExtra("yazi")
        val ay=intent.getLongExtra("ay",0)
        val yil=intent.getLongExtra("yil",0)
        findViewById<Button>(R.id.yil).setText(yil.toString())
        findViewById<Button>(R.id.ay).setText(ay.toString())
        findViewById<Button>(R.id.gün).setText(gün.toString())
        findViewById<TextView>(R.id.text).setText(yazi)
    }
}
