package com.basket.publicdairy.View.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.basket.publicdairy.R

class Intro : AppCompatActivity() {
    var i:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        supportActionBar?.hide()
        findViewById<ImageButton>(R.id.introButton).setOnClickListener {
            if(i==0){
                findViewById<TextView>(R.id.introText).setText(R.string.intro2)
                findViewById<ImageView>(R.id.introImage).setImageResource(R.drawable.icons8openbook100)
            }
            else{
                startActivity(Intent(this@Intro,MainMenu::class.java))
            }
            i++
        }
    }
}
