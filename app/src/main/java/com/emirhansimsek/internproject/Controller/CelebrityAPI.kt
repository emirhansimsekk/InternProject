package com.emirhansimsek.internproject.Controller

import com.emirhansimsek.internproject.Model.Celebrity
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
//https://run.mocky.io/v3/5e518f3f-bf14-4916-a72b-1ffb3febc75a
//https://run.mocky.io/v3/eabe7be0-6a31-42d7-8f46-f8f3bff54b12
interface CelebrityAPI {
    @GET("v3/eabe7be0-6a31-42d7-8f46-f8f3bff54b12")
    fun getCelebrity() : Call<Celebrity>
}