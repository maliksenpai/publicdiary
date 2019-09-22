package com.basket.publicdairy.Model

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object Firebase {
     var firebase: DatabaseReference? =null
    fun getInstance(): DatabaseReference? {
        if(firebase==null){
            firebase=FirebaseDatabase.getInstance().getReference()        }
        return firebase
    }
}