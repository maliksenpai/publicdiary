package com.basket.publicdairy.Presenter

import android.util.Log

class ReadPresenter {
    fun tarih(tarih:String) : List<Int>{
        Log.d("gelenn", tarih[1].toString())
        Log.d("gelenn", tarih[2].toString())
        Log.d("gelenn", tarih[3].toString())
        Log.d("gelenn", tarih[4].toString())
        Log.d("gelenn", tarih[5].toString())
        return emptyList()
    }
}

//01/01/2019  1/01/2019  1/1/2019  01/1/2019