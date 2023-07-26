package com.emirhansimsek.internproject.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emirhansimsek.internproject.Controller.CelebrityAPIService
import com.emirhansimsek.internproject.Controller.CustomAdapterWoman
import com.emirhansimsek.internproject.Controller.customAdapterCelebrities
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R
import com.emirhansimsek.internproject.databinding.FragmentManBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [ManFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ManFragment : Fragment(R.layout.fragment_man) {

    private var fragmentManBinding: FragmentManBinding? = null
    private val binding get() = fragmentManBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_man, container, false)
        getData()
        fragmentManBinding = FragmentManBinding.inflate(inflater,container,false)

        return binding.root
    }



    fun getData(){
        var Celebrities = ArrayList<Celebrity.User.Actors> ()

        var celebrity: Celebrity.User.Actors
        println("getdata")
        val celebrityApi = CelebrityAPIService.celebrityAPI.getCelebrity()
        celebrityApi.enqueue(object: Callback<Celebrity> {
            override fun onResponse(
                call: Call<Celebrity>,
                response: Response<Celebrity>
            ) {

                println("onResponse")
                val responseBody = response.body()!!

                var a = 0

                val manList = responseBody.user_type.man
                // println(user[0].name_surname)

                //println(responseBody.user_type[0].man[0].name_surname)
                /*for(clb in manList){
                    //println(responseBody.user_type[0].man[0].name_surname)
                    if(clb!=null){
                        //println(responseBody.user_type[0].man[0].name_surname)
                        celebrity = Celebrity.User.Actors(clb.name_surname,clb.age,
                            clb.phone_number,clb.email,clb.birthdate,clb.image)
                        Celebrities.add(celebrity)
                        println(Celebrities[a].name_surname)
                        println(Celebrities.size)
                        a++
                    }
                }*/
                recylerView(manList)


                //recyclerView(Celebrities)

            }

            override fun onFailure(call: Call<Celebrity>, t: Throwable) {
                println("onFailure")
                println(t.printStackTrace())
            }

        }
        )
    }


    fun recylerView(manList:List<Celebrity.User.Actors>){
        val layoutManager = LinearLayoutManager(context)
        var recyclerView = binding.fragmentRecyclerView

        recyclerView.layoutManager = layoutManager


        val adapter = customAdapterCelebrities(manList)


        recyclerView.adapter = adapter

    }



}