package com.artemissoftware.bundleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artemissoftware.bundleapp.weather.WeatherActivity
import com.artemissoftware.bundleapp.weather.WeatherForecastActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(getApplicationContext(), WeatherActivity::class.java)
        startActivity(intent)
    }
}
