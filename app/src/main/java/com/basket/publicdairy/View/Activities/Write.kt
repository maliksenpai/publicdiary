package com.basket.publicdairy.View.Activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.basket.publicdairy.Presenter.WritePresenter
import com.basket.publicdairy.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_write.*
import java.util.*

class Write : AppCompatActivity(){
    var presenter: WritePresenter = WritePresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        presenter.viewata(this)
        val gün:Button=findViewById(R.id.gün)
        val ay:Button=findViewById(R.id.ay)
        val yil:Button=findViewById(R.id.yil)
        gün.setOnClickListener { datepicker() }
        ay.setOnClickListener { datepicker() }
        yil.setOnClickListener { datepicker() }
        findViewById<FloatingActionButton>(R.id.writefab).setOnClickListener { presenter.writedata(findViewById<EditText>(R.id.text).text.toString(),gün.text.toString() , ay.text.toString() , yil.text.toString() ) }
        findViewById<EditText>(R.id.text).setOnKeyListener OnKeyListener@{ v, keyCode, event ->
            if(keyCode==KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP){
                presenter.writedata(findViewById<EditText>(R.id.text).text.toString(),gün.text.toString() , ay.text.toString() , yil.text.toString() )
                return@OnKeyListener true
            }
            false
        }
    }
    fun datepicker(){
        var calendar=Calendar.getInstance()
        val date=DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            Log.d("gelen", dayOfMonth.toString())
            Log.d("gelen", year.toString())
            val intay:Int=month+1
            gün.setText(dayOfMonth.toString())
            ay.setText(intay.toString())
            yil.setText(year.toString())
        }
        DatePickerDialog(this@Write,date,calendar.get(Calendar.DAY_OF_YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR)).show()
    }
    fun tarihhatali(){
        Toast.makeText(this,"Tarih hatali",Toast.LENGTH_LONG).show()
    }
    fun kisatext(){
        Toast.makeText(this,"yazi fazla kisa(min 15 karakter)",Toast.LENGTH_LONG).show()
    }
}
