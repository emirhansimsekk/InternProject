package com.emirhansimsek.internproject.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
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
 * Use the [WomanFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WomanFragment : Fragment() {

    private var fragmentManBinding: FragmentManBinding? = null
    private val binding get() = fragmentManBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_woman, container, false)
        getData()
        fragmentManBinding = FragmentManBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            requireActivity().supportFragmentManager.popBackStack()
        }
    }


    fun getData(){
        var Actresses = ArrayList<Celebrity.User.Actresses> ()

        var celebrity: Celebrity.User.Actresses
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

                val womanList = responseBody.user_type.woman
                //println(user[0].name_surname)

                //println(responseBody.user_type[0].man[0].name_surname)
                for(clb in womanList){
                    //println(responseBody.user_type[0].man[0].name_surname)
                    if(clb!=null){
                        //println(responseBody.user_type[0].man[0].name_surname)
                        celebrity = Celebrity.User.Actresses(clb.name_surname,clb.age,
                            clb.phone_number,clb.email,clb.birthdate,clb.image)
                        Actresses.add(celebrity)
                        println(Actresses[a].name_surname)
                        println(Actresses.size)
                        a++
                    }
                }
                recyclerView(Actresses)

            }

            override fun onFailure(call: Call<Celebrity>, t: Throwable) {
                println("onFailure")
                println(t.printStackTrace())
            }

        }
        )
    }

    fun recyclerView(womanList:List<Celebrity.User.Actresses>){
        val layoutManager = LinearLayoutManager(context)
        var recyclerView = binding.fragmentRecyclerView


        recyclerView.layoutManager = layoutManager


        val adapter = CustomAdapterWoman(womanList)


        recyclerView.adapter = adapter
    }
}