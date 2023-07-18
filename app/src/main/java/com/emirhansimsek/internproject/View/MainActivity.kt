package com.emirhansimsek.internproject.View

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        println("enqueue disi ${Celebrities.size}")
       /* val layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = layoutManager
        val adapter = customAdapterCelebrities(Celebrities)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter*/
        val Celebrities1 = ArrayList<Celebrity.Actors>()
        println("recyclerview")
        /*val celebrity = Celebrity.Actors("Emirhan", "1","2","3","4")
        Celebrities1.add(celebrity)*/
        /*val layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = layoutManager
        val adapter = customAdapterCelebrities(Celebrities)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter*/
    }

    fun recyclerView(Celebrities: ArrayList<Celebrity.Actors>){
        val layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = layoutManager
        val adapter = customAdapterCelebrities(Celebrities)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
        println(Celebrities[0].name_surname)
    }


}