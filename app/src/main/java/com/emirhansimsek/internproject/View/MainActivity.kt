package com.emirhansimsek.internproject.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emirhansimsek.internproject.Controller.CelebrityAPIService
import com.emirhansimsek.internproject.Controller.customAdapterCelebrities
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Celebrities : List<Celebrity>
        val celebrityAPIService = CelebrityAPIService()
        Celebrities = celebrityAPIService.celebrityApi

        val layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = layoutManager
        val adapter = customAdapterCelebrities(Celebrities)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter

        //val celebrityAPIService = CelebrityAPIService()
        /**val disposable = CompositeDisposable()

        disposable.add(
            celebrityAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Celebrity>>(){
                    override fun onSuccess(t: List<Celebrity>) {
                        Celebrities = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                }

                )
        )*/


    }

}