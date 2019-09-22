package com.basket.publicdairy.Model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.basket.publicdairy.R
import com.basket.publicdairy.View.Activities.Read

class DairyAdaptor(val liste:MutableList<DairyModule>):RecyclerView.Adapter<DairyAdaptor.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DairyAdaptor.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
            return liste.size
        }

    override fun onBindViewHolder(holder: DairyAdaptor.ViewHolder, position: Int) {
        holder.button.setText(liste.get(position).gün.toString() + "/" + liste.get(position).ay.toString() + "/" + liste.get(position).yil.toString())
        holder.button.setOnClickListener {
            var intent:Intent= Intent(it.context, Read::class.java)
            intent.putExtra("yazi",liste.get(position).Yazi)
            intent.putExtra("gün",liste.get(position).gün)
            intent.putExtra("ay", liste.get(position).ay)
            intent.putExtra("yil", liste.get(position).yil)
            it.context.startActivity(intent)
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var button: Button =itemView.findViewById(R.id.listbutton)

    }
}