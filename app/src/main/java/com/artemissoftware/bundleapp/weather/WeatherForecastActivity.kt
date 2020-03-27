package com.artemissoftware.bundleapp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.bundleapp.R

class WeatherForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_forecast)


        var rcl_forecast = findViewById<RecyclerView>(R.id.rcl_forecast)



    }



}
