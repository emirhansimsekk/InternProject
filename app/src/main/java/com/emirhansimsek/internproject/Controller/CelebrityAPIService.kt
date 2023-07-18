package com.emirhansimsek.internproject.Controller

import com.emirhansimsek.internproject.Model.Celebrity
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object CelebrityAPIService {
    //https://run.mocky.io/v3/5e518f3f-bf14-4916-a72b-1ffb3febc75a
    private val BASE_URL="https://run.mocky.io/"
    val gson = GsonBuilder()
        .setLenient()
        .create()
    private val api: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val celebrityAPI = api.create(CelebrityAPI::class.java)


}