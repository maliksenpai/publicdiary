package com.basket.publicdairy.Model

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.basket.publicdairy.View.Activities.RandomRead
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlin.random.Random

class RandomReadModel {
    fun verisec(context: Context){
        var liste= mutableListOf<DairyModule>()
        Log.d("gelen1",liste?.size.toString())
        val firebase: DatabaseReference? =Firebase.getInstance()?.child("dairies")
        val listener=object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                p0?.children.forEach {
                    var dyazi=it.child("yazi").getValue().toString()
                    var deposta=it.child("eposta").getValue().toString()
                    var dgün=it.child("gün").getValue()
                    var day=it.child("ay").getValue()
                    var dyil=it.child("yil").getValue()
                    Log.d("gelen", dgün.toString())
                    liste?.add(DairyModule(dgün as Long, day as Long, dyil as Long,dyazi,deposta))

                }
                Log.d("gelen3",liste?.size.toString())
                val random=java.util.Random()
                val randomsayi=random.nextInt(liste?.size)
                var intent:Intent= Intent(context,RandomRead::class.java)
                intent.putExtra("gün",liste?.get(randomsayi).gün)
                intent.putExtra("ay",liste?.get(randomsayi).ay)
                intent.putExtra("yil",liste?.get(randomsayi).yil)
                intent.putExtra("yazi",liste?.get(randomsayi).Yazi)
                context.startActivity(intent)
            }
        }
        Log.d("gelen4",liste?.size.toString())
        firebase?.addValueEventListener(listener)
    }
}