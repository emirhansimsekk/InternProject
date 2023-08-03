package com.emirhansimsek.internproject.View

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.format.Time
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.emirhansimsek.internproject.Controller.CelebrityAPIService
import com.emirhansimsek.internproject.Controller.ItemViewModel
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
    private val viewModel: ItemViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val Celebrities = ArrayList<Celebrity.Actors>()
        setContentView(R.layout.activity_main)
        this.setTitle("Celebrities")
        var tabs = arrayOf("Man","Woman")
        var pager = findViewById<ViewPager2>(R.id.view_Pager)
        var tabLayout = findViewById<TabLayout>(R.id.tab_Layout)
        pager.adapter = PageAdapter(supportFragmentManager, lifecycle)
        //pager.setCurrentItem(1)
        getData()
        TabLayoutMediator(tabLayout,pager){
            tab,position ->
            tab.text = tabs[position]
        }.attach()




        }

    fun getData(){

        var bundle: Bundle
        var Actors = ArrayList<Celebrity.User.Celebrities>()
        var Actresses = ArrayList<Celebrity.User.Celebrities>()
        var celebrity: Celebrity.User.Celebrities

        val celebrityApi = CelebrityAPIService.celebrityAPI.getCelebrity()
        celebrityApi.enqueue(object : Callback<Celebrity>{
            override fun onResponse(call: Call<Celebrity>, response: Response<Celebrity>) {
                val responseBody = response.body()!!
                val celebrities = responseBody.user_type.celebrities
                for (celebrity in celebrities){
                    if(celebrity!=null){
                        if(celebrity.gender=="man"){
                            Actors.add(celebrity)

                        }
                        else{
                            Actresses.add(celebrity)
                        }

                    }
                }

                viewModel.selectItemMan(Actors)
                viewModel.selectItemWoman(Actresses)


            }

            override fun onFailure(call: Call<Celebrity>, t: Throwable) {
                println("onFailure")
                println(t.printStackTrace())

            }




        })


    }







}