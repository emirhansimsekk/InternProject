package com.emirhansimsek.internproject.Controller

import com.emirhansimsek.internproject.Model.Celebrity
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
//https://run.mocky.io/v3/5e518f3f-bf14-4916-a72b-1ffb3febc75a
interface CelebrityAPI {
    @GET("v3/5e518f3f-bf14-4916-a72b-1ffb3febc75a")
    fun getCelebrity() : Call<Celebrity>
}