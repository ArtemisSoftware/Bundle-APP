package com.artemissoftware.bundleapp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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


        var retriever = WeatherRetriever()

        val callback = object : retrofit2.Callback<List<Forecast>>{

            override fun onFailure(call: Call<List<Forecast>>, t: Throwable) {
                println("t: " + t.message)
            }

            override fun onResponse(call: Call<List<Forecast>>, response: Response<List<Forecast>>) {
                println("response: " + response)
            }

        }

        retriever.getForecast(callback)
    }



}
