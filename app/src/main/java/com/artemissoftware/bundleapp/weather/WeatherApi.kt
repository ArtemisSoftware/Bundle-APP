package com.artemissoftware.bundleapp.weather

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherApi {

    @GET("bins/1e2e3k")
    fun getForecast() : Call<List<Forecast>>


}

class Forecast(val high: String, val low: String)

class WeatherRetriever{

    val service :  WeatherApi

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://api.myjson.com/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherApi::class.java)
    }

    fun getForecast(callback : Callback<List<Forecast>>){
        val call = service.getForecast()

        call.enqueue(callback)
    }

}