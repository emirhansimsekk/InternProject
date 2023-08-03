package com.emirhansimsek.internproject.Controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R
import com.emirhansimsek.internproject.View.LoadingScreen
import com.emirhansimsek.internproject.View.profileActivity
import com.emirhansimsek.internproject.databinding.CelebritiesRowBinding
import com.squareup.picasso.Picasso

class CustomAdapterWoman(val actreses: List<Celebrity.User.Celebrities>): RecyclerView.Adapter<CustomAdapterWoman.womanHolder>() {
    private lateinit var binding : CelebritiesRowBinding
    private lateinit var mListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener (listener: onItemClickListener){
        mListener = listener
    }

    class womanHolder(val binding: CelebritiesRowBinding, listener: onItemClickListener): RecyclerView.ViewHolder(binding.root) {
            init{
                binding.cardView.setOnClickListener {
                    listener.onItemClick(adapterPosition)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): womanHolder {
        binding = CelebritiesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return womanHolder(binding, mListener)
    }

    override fun getItemCount(): Int {
       return actreses.size
    }

    override fun onBindViewHolder(holder: womanHolder, position: Int) {


        val actress = actreses[position]
        holder.binding.txtName.text = actress.name_surname
        holder.binding.txtBirthdate.text = actress.birthdate

        Picasso.get().load(actress.resim).into(holder.itemView.findViewById<ImageView>(R.id.imageView))
    }
}