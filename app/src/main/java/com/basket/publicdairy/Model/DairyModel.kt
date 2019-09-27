package com.basket.publicdairy.Model

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class DairyModel {
    fun vericek(isim:String,list:RecyclerView,context: Context): MutableList<DairyModule>? {
        var liste= mutableListOf<DairyModule>()
        Log.d("gelen1",liste?.size.toString())
        val firebase: DatabaseReference? =Firebase.getInstance()?.child("dairies")
        val listener=object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                p0?.children.forEach {
                    var yazi=it.child("yazi").getValue().toString()
                    var eposta=it.child("eposta").getValue().toString()
                    var gün=it.child("gün").getValue()
                    var ay=it.child("ay").getValue()
                    var yil=it.child("yil").getValue()
                    Log.d("gelennn", (gün as Long +2 ).toString())
                    if(isim==eposta){
                        liste?.add(DairyModule(gün as Long, ay as Long, yil as Long,yazi,eposta))
                    }

                }
                Log.d("gelen3",liste?.size.toString())
                list.layoutManager=LinearLayoutManager(context)
                list.adapter=DairyAdaptor(liste)
            }
            }
        Log.d("gelen4",liste?.size.toString())
        firebase?.addValueEventListener(listener)
        return liste
    }
}

