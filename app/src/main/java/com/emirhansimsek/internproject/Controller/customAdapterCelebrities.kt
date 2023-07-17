package com.emirhansimsek.internproject.Controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R

class customAdapterCelebrities(val celebrities: List<Celebrity>) : RecyclerView.Adapter<customAdapterCelebrities.celebritiesHolder>() {
    class celebritiesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): celebritiesHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.celebrities_row,parent,false)
        return celebritiesHolder(itemView)
    }

    override fun getItemCount(): Int {
        return celebrities.size
    }

    override fun onBindViewHolder(holder: celebritiesHolder, position: Int) {
        var celebrity = celebrities[position]
        holder.itemView.findViewById<TextView>(R.id.txt_Name).text = celebrity.name_surname
        holder.itemView.findViewById<TextView>(R.id.txt_Birthdate).text = celebrity.birthdate
    }
}