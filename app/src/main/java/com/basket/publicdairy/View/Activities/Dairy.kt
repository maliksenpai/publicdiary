package com.basket.publicdairy.View.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.basket.publicdairy.Presenter.DairyPresenter
import com.basket.publicdairy.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Dairy : AppCompatActivity() {
    var presenter:DairyPresenter= DairyPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dairy)
        val recyclerview:RecyclerView=findViewById(R.id.list)
        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener { presenter.fab(this) }
        presenter?.mydairy(recyclerview,"deneme",this)
        val action=supportActionBar
        action?.setTitle(R.string.app_name)
        action?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
