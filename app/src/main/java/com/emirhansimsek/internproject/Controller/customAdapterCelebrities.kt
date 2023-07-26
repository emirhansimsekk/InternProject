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
import com.emirhansimsek.internproject.View.LoadingScreen
import com.emirhansimsek.internproject.View.profileActivity
import com.emirhansimsek.internproject.databinding.CelebritiesRowBinding
import com.squareup.picasso.Picasso

class customAdapterCelebrities(val celebrities: List<Celebrity.User.Actors>) : RecyclerView.Adapter<customAdapterCelebrities.celebritiesHolder>() {
    class celebritiesHolder(val binding: CelebritiesRowBinding ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): celebritiesHolder {
        val binding = CelebritiesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return celebritiesHolder(binding)
    }

    override fun getItemCount(): Int {
        return celebrities.size
    }

    override fun onBindViewHolder(holder: celebritiesHolder, position: Int) {
        val celebrity = celebrities[position]
        holder.binding.txtName.text = celebrity.name_surname


        holder.binding.txtBirthdate.text = celebrity.birthdate
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,LoadingScreen::class.java)
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