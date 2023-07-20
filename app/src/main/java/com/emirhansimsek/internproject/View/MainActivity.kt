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
import com.airbnb.lottie.LottieAnimationView
import com.emirhansimsek.internproject.Controller.CelebrityAPIService
import com.emirhansimsek.internproject.Controller.customAdapterCelebrities
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val Celebrities = ArrayList<Celebrity.Actors>()
        setContentView(R.layout.activity_main)
        this.setTitle("Celebrities")
        getData()

        }

    fun getData(){
        var Celebrities = ArrayList<Celebrity.Actors>()
        var celebrity: Celebrity.Actors
        println("getdata")
        val celebrityApi = CelebrityAPIService.celebrityAPI.getCelebrity()
        celebrityApi.enqueue(object: Callback<Celebrity>{
            override fun onResponse(
                call: Call<Celebrity>,
                response: Response<Celebrity>
            ) {
                println("onResponse")
                val responseBody = response.body()!!


                //println(responseBody.users[2].birthdate)
                var a = 0

                for(clb in responseBody.users){
                    if(clb!=null){
                        //println("fora girdi 12356452")

                        celebrity = Celebrity.Actors(clb.name_surname,clb.age,
                        clb.phone_number,clb.email,clb.birthdate)
                        Celebrities.add(celebrity)
                        println(Celebrities[a].name_surname)
                        println(Celebrities.size)
                        a++
                    }
                }
                recyclerView(Celebrities)

            }

            override fun onFailure(call: Call<Celebrity>, t: Throwable) {
                println("onFailure")
                println(t.printStackTrace())
            }

        }
        )

    }

    fun recyclerView(Celebrities: ArrayList<Celebrity.Actors>){
        val layoutManager = LinearLayoutManager(this)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = customAdapterCelebrities(Celebrities)
        recyclerView.adapter = adapter




    }


}