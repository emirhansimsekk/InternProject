package com.emirhansimsek.internproject.View

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emirhansimsek.internproject.Controller.CelebrityAPIService
import com.emirhansimsek.internproject.Controller.CustomAdapterWoman
import com.emirhansimsek.internproject.Controller.ItemViewModel
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
    private val viewModel: ItemViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_woman, container, false)
        fragmentManBinding = FragmentManBinding.inflate(inflater,container,false)

        viewModel.selectedItemWoman.observe(viewLifecycleOwner, {
            recyclerView(it)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            requireActivity().supportFragmentManager.popBackStack()
        }
    }




    fun recyclerView(womanList:List<Celebrity.User.Celebrities>){

            val layoutManager = LinearLayoutManager(context)
            var recyclerView = binding.fragmentRecyclerView


            recyclerView.layoutManager = layoutManager
            val adapter = CustomAdapterWoman(womanList)
            recyclerView.adapter = adapter
            val loadingAnimation = binding.ltLoadingAnimation
            adapter.setOnItemClickListener(object : CustomAdapterWoman.onItemClickListener{
                override fun onItemClick(position: Int) {
                    var woman = womanList[position]
                    recyclerView.alpha = 0.3f
                    loadingAnimation.playAnimation()
                    val intent = Intent(this@WomanFragment.context, profileActivity::class.java)
                    intent.putExtra("name_surname",woman.name_surname)
                    intent.putExtra("age",woman.age)
                    intent.putExtra("phone_number",woman.phone_number)
                    intent.putExtra("email",woman.email)
                    intent.putExtra("birthdate",woman.birthdate)
                    intent.putExtra("gender",woman.gender)
                    intent.putExtra("image",woman.resim)
                    startActivity(intent)
                }

            })


    }


}