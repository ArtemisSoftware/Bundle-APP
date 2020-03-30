package com.artemissoftware.bundleapp.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.bundleapp.R

class WeatherViewHolder(inflater: LayoutInflater, parent: ViewGroup) :

    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list_weather, parent, false)) {

    private var weatherMain: TextView? = null
    private var weatherDescription: TextView? = null

    init {
        weatherMain = itemView.findViewById(R.id.weatherMain)
        weatherDescription = itemView.findViewById(R.id.weatherDescription)
    }

    fun bind(weather: WeatherDescription) {
        weatherMain?.text = weather.main
        weatherDescription?.text = weather.description
    }

}