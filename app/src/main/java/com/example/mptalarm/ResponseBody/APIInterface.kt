package com.example.mptalarm.ResponseBody

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val key1 = "AIzaSyCcAJbjYytOzpW2cZVpjuXl_pdqnsl9OKA"

interface APIInterface {

    @GET("/maps/api/directions/json")
    fun getRoute(
            @Query("origin") startlocation: String,
            @Query("destination") endlocation: String,
            @Query("sensor") sensor: Boolean,
            @Query("mode") mode: String,
            @Query("key") key: String = key1
    ): Call<UrlModel>

}