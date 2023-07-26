package com.emirhansimsek.internproject.View

import android.animation.Animator
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.format.Time
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.emirhansimsek.internproject.Controller.CelebrityAPIService
import com.emirhansimsek.internproject.Controller.PageAdapter
import com.emirhansimsek.internproject.Controller.customAdapterCelebrities
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R
import com.emirhansimsek.internproject.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val Celebrities = ArrayList<Celebrity.Actors>()
        setContentView(R.layout.activity_main)
        this.setTitle("Celebrities")
        var tabs = arrayOf("Man","Woman")
        var pager = binding.viewPager
        var tabLayout = binding.tabLayout
        pager.adapter = PageAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout,pager){
            tab,position ->
            tab.text = tabs[position]
        }.attach()

        }






}