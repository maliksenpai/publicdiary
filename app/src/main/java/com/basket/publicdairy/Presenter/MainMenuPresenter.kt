package com.basket.publicdairy.Presenter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.core.content.ContextCompat.startActivity
import com.basket.publicdairy.Model.RandomReadModel
import com.basket.publicdairy.View.Activities.Dairy
import com.basket.publicdairy.View.Activities.Intro
import com.basket.publicdairy.View.Activities.RandomRead


class MainMenuPresenter {
    fun intro(context: Context,intro:SharedPreferences){
        if(intro.getBoolean("intro",true)){
            context.startActivity(Intent(context, Intro::class.java))
            intro.edit().putBoolean("intro",false).commit()
        }
    }
    fun dairy(context:Context){
        context.startActivity(Intent(context, Dairy::class.java))
    }
    fun read(context: Context){
        val veri= RandomReadModel().verisec(context)
    }
}