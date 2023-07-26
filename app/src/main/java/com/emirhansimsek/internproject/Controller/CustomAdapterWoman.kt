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

class CustomAdapterWoman(val actreses: List<Celebrity.User.Actresses>): RecyclerView.Adapter<CustomAdapterWoman.womanHolder>() {
    class womanHolder(val binding: CelebritiesRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): womanHolder {
        val binding = CelebritiesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return womanHolder(binding)
    }

    override fun getItemCount(): Int {
       return actreses.size
    }

    override fun onBindViewHolder(holder: womanHolder, position: Int) {
        val actress = actreses[position]

        holder.binding.txtName.text = actress.name_surname
        holder.binding.txtBirthdate.text = actress.birthdate
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, LoadingScreen::class.java)
            intent.putExtra("name_surname",actress.name_surname)
            intent.putExtra("age",actress.age)
            intent.putExtra("phone_number",actress.phone_number)
            intent.putExtra("email",actress.email)
            intent.putExtra("birthdate",actress.birthdate)
            holder.itemView.context.startActivity(intent)
        }
        Picasso.get().load(actress.image).into(holder.itemView.findViewById<ImageView>(R.id.imageView))
    }
}