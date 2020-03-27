package com.artemissoftware.bundleapp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artemissoftware.bundleapp.R

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
    }
}
