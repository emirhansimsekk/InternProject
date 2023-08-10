package com.emirhansimsek.internproject.View

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
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
 * Use the [ManFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ManFragment : Fragment(R.layout.fragment_man) {

    private var fragmentManBinding: FragmentManBinding? = null
    private val binding get() = fragmentManBinding!!
    private val viewModel: ItemViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_man, container, false)

        fragmentManBinding = FragmentManBinding.inflate(inflater,container,false)

        viewModel.selectedItemMan.observe(viewLifecycleOwner,{
            recylerView(it)
        })


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            requireActivity().supportFragmentManager.popBackStack()
        }
    }



    private fun recylerView(manList:List<Celebrity.User.Celebrities>){

            val layoutManager = LinearLayoutManager(context)
            var recyclerView = binding.fragmentRecyclerView

            recyclerView.layoutManager = layoutManager
            val loadingAnimation = binding.ltLoadingAnimation
            val adapter = customAdapterCelebrities(manList)
            recyclerView.adapter = adapter
            adapter.setOnItemClickListener(object :customAdapterCelebrities.onItemClikListener{
                override fun onItemClick(position: Int) {
                    var man = manList[position]
                            recyclerView.alpha = 0.3f
                            loadingAnimation.playAnimation()
                            val intent = Intent(this@ManFragment.context,profileActivity::class.java)
                            intent.putExtra("name_surname",man.name_surname)
                            intent.putExtra("age",man.age)
                            intent.putExtra("phone_number",man.phone_number)
                            intent.putExtra("email",man.email)
                            intent.putExtra("birthdate",man.birthdate)
                            intent.putExtra("gender",man.gender)
                            intent.putExtra("positin",position)
                            intent.putExtra("image",man.resim)
                            startActivity(intent)

                }


            })


    }



}