package com.emirhansimsek.internproject.Controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R
import com.emirhansimsek.internproject.View.LoadingScreen
import com.emirhansimsek.internproject.View.ManFragment
import com.emirhansimsek.internproject.View.ProfileDialog
import com.emirhansimsek.internproject.View.profileActivity
import com.emirhansimsek.internproject.databinding.CelebritiesRowBinding
import com.squareup.picasso.Picasso



class customAdapterCelebrities(val celebrities: List<Celebrity.User.Celebrities>, var context: Context) : RecyclerView.Adapter<customAdapterCelebrities.celebritiesHolder>() {

    private lateinit var binding : CelebritiesRowBinding
    private lateinit var mListener : onItemClikListener
    private lateinit var bindingDialog: ProfileDialog

    interface onItemClikListener{
        fun onItemClick(position : Int)

    }

    fun setOnItemClickListener(listener: onItemClikListener){
        mListener = listener
    }

    class celebritiesHolder(var binding: CelebritiesRowBinding,  listener: onItemClikListener )
        : RecyclerView.ViewHolder(binding.root) {
           init {
                binding.cardView.setOnClickListener {

                    listener.onItemClick(adapterPosition)

                }
           }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): celebritiesHolder {
        binding = CelebritiesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return celebritiesHolder(binding, mListener)
    }

    override fun getItemCount(): Int {
        return celebrities.size
    }

    override fun onBindViewHolder(holder: celebritiesHolder, position: Int) {
        val celebrity = celebrities[position]
        holder.binding.txtName.text = celebrity.name_surname
        holder.binding.txtBirthdate.text = celebrity.birthdate
        if(position==3){
            holder.binding.txtName.setTextColor(Color.parseColor("#FFFF4B65"))
        }
          Picasso.get().load(celebrity.resim).into(holder.itemView.findViewById<ImageView>(R.id.imageView))
        holder.binding.cardView.setOnLongClickListener {
            showProfileDialog(celebrity)
            return@setOnLongClickListener true
        }
    }

    fun showProfileDialog(man: Celebrity.User.Celebrities){
        val profileDialog = ProfileDialog(man)
        val fragmentManager = (context as AppCompatActivity).supportFragmentManager
        profileDialog.show(fragmentManager,"DialogProfile")


    }
}