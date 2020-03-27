package com.artemissoftware.bundleapp.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.artemissoftware.bundleapp.R

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        (findViewById(R.id.btn_get_forecast) as Button).setOnClickListener{btn_get_forecast__OnClickListener(it)};

    }

    private fun btn_get_forecast__OnClickListener(it: View?) {

        val intent = Intent(getApplicationContext(), WeatherForecastActivity::class.java)
        startActivity(intent)
    }


}
