package com.basket.publicdairy.View.Activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.basket.publicdairy.Presenter.MainMenuPresenter
import com.basket.publicdairy.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainMenu : AppCompatActivity() {
    private val kod:Int=5
    private lateinit var GoogleSignOption:GoogleSignInOptions
    private lateinit var GoogleSignClient:GoogleSignInClient
    private var Presenter: MainMenuPresenter =MainMenuPresenter()
    private lateinit var Firebase:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        val intro: SharedPreferences =getSharedPreferences("intro",0)
        Presenter.intro(this,intro)
        Firebase= FirebaseAuth.getInstance()
        GoogleSign()
        findViewById<ImageButton>(R.id.mainbutton1).setOnClickListener { Presenter.dairy(this) }
        findViewById<ImageButton>(R.id.mainbutton2).setOnClickListener { Presenter.read(this) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data) /*
        if (requestCode==kod){
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account=task.getResult()
            val credential=GoogleAuthProvider.getCredential(account?.idToken,null)
            FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                if(it.isSuccessful){
                    Log.d("gelen","oldu")
                }
            }
        } */
    }
    fun GoogleSign(){
     /*   GoogleSignOption=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("AIzaSyBVkKErosEi4ECOZbyjr9_Ig0iwXgAWRFU").requestEmail().build()
        GoogleSignClient=com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(this,GoogleSignOption)
        val intent:Intent=GoogleSignClient.signInIntent
        startActivityForResult(intent,kod) */
    }
}
