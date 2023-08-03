package com.emirhansimsek.internproject.Controller

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emirhansimsek.internproject.Model.Celebrity

class ItemViewModel: ViewModel() {
    private val mutableSelectedItemMan = MutableLiveData<ArrayList<Celebrity.User.Celebrities>>()
    val selectedItemMan: LiveData<ArrayList<Celebrity.User.Celebrities>> get() = mutableSelectedItemMan
    private val mutableSelectedItemWoman = MutableLiveData<ArrayList<Celebrity.User.Celebrities>>()
    val selectedItemWoman: LiveData<ArrayList<Celebrity.User.Celebrities>> get() = mutableSelectedItemWoman


    fun selectItemMan(celebrity: ArrayList<Celebrity.User.Celebrities>){
        mutableSelectedItemMan.value = celebrity
    }
    fun selectItemWoman(celebrity: ArrayList<Celebrity.User.Celebrities>){
        mutableSelectedItemWoman.value = celebrity
    }
    
}