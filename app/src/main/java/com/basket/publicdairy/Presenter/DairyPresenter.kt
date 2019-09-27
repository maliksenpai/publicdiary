package com.basket.publicdairy.Presenter

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.basket.publicdairy.Model.DairyModel
import com.basket.publicdairy.Model.DairyModule
import com.basket.publicdairy.View.Activities.Dairy
import com.basket.publicdairy.View.Activities.Write

class DairyPresenter {
    fun fab(context:Context){
        context.startActivity(Intent(context, Write::class.java))
    }
    fun mydairy(list:RecyclerView,isim:String,context: Context){
        val model:MutableList<DairyModule>?=DairyModel()?.vericek(isim,list,context)
    }
}