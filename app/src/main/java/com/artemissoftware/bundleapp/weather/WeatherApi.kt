package com.artemissoftware.bundleapp.weather

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherApi {

    //http://api.openweathermap.org/data/2.5/weather?q=Dubai&APPID=653b1f0bf8a08686ac505ef6f05b94c2
    //http://api.openweathermap.org/data/2.5/forecast/daily?q=Dubai&cnt=5&appid=653b1f0bf8a08686ac505ef6f05b94c2

    @GET("daily?q=Dubai&cnt=5&appid=653b1f0bf8a08686ac505ef6f05b94c2")
    fun getForecast() : Call<Weather>


}

class Weather(val city: CityWeather, val list: List<ListWeather>)
class CityWeather(val name: String)
class ListWeather (val weather: List<WeatherDescription>)
class WeatherDescription (val main: String, val description: String)




class WeatherRetriever{

    val service :  WeatherApi

    init {
        val retrofit = Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/forecast/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherApi::class.java)
    }

    fun getForecast(callback : Callback<Weather>){
        val call = service.getForecast()

        call.enqueue(callback)
    }

}