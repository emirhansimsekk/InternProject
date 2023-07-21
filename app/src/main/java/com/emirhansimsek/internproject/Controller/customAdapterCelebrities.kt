package com.emirhansimsek.internproject.Controller

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R
import com.emirhansimsek.internproject.View.profileActivity
import com.squareup.picasso.Picasso

class customAdapterCelebrities(val celebrities: List<Celebrity.User.Actors>) : RecyclerView.Adapter<customAdapterCelebrities.celebritiesHolder>() {
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
        val celebrity = celebrities[position]

        holder.itemView.findViewById<TextView>(R.id.txt_Name).text = celebrity.name_surname
        holder.itemView.findViewById<TextView>(R.id.txt_Birthdate).text = celebrity.birthdate
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,profileActivity::class.java)
            intent.putExtra("name_surname",celebrity.name_surname)
            intent.putExtra("age",celebrity.age)
            intent.putExtra("phone_number",celebrity.phone_number)
            intent.putExtra("email",celebrity.email)
            intent.putExtra("birthdate",celebrity.birthdate)
            holder.itemView.context.startActivity(intent)
        }
        Picasso.get().load(celebrity.image).into(holder.itemView.findViewById<ImageView>(R.id.imageView))
    }
}