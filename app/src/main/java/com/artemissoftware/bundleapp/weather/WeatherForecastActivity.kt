package com.artemissoftware.bundleapp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.bundleapp.R
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class WeatherForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_forecast)



        var rcl_forecast = findViewById<RecyclerView>(R.id.rcl_forecast)

        rcl_forecast.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            //adapter = WeatherListAdapter(mNicolasCageMovies)
        }



        val callback = object : retrofit2.Callback<Weather>{

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                println("t: " + t.message)
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                println("response: " + response)

                title = response?.body()?.city?.name

                rcl_forecast.apply {
                    adapter = response?.body()?.list?.let { WeatherListAdapter(it) }
                }
            }

        }

        var searchTerm = intent.extras?.getString("searchTerm")

        if(searchTerm == ""){
            searchTerm = "Madrid"
        }

        var retriever = WeatherRetriever()
        retriever.getForecast(callback, searchTerm!!)
    }



}
