package com.basket.publicdairy.Presenter

import android.util.Log
import com.basket.publicdairy.Model.DairyModule
import com.basket.publicdairy.Model.Firebase
import com.basket.publicdairy.View.Activities.Write

class WritePresenter{
    var write: Write?=null
    fun viewata(w:Write){
        write=w
    }
    fun writedata(text:String,gün:String,ay:String,yil:String){
        Log.d("gelen","asdasd")
        val lgün=gün.toLongOrNull()
        val lay=ay.toLongOrNull()
        val lyil=yil.toLongOrNull()
        val llgün=gün.toLong()
        val llay=ay.toLong()
        val llyil=yil.toLong()
        Log.d("gelennn", lgün.toString())
        Log.d("gelennn", lay.toString())
        Log.d("gelennn", lyil.toString())
        Log.d("gelennn", llgün.toString())
        Log.d("gelennn", llay.toString())
        Log.d("gelennn", llyil.toString())
        var database= Firebase.getInstance()?.child("dairies")?.push()
        val veri: DairyModule = DairyModule(lgün, lay, lyil,text,"deneme")
        database?.setValue(veri)
            if(text.toString().length>20){
                database?.push()
            }else{
                write?.kisatext()
                Log.d("gelen","olmadi")
            }
        }
    }
