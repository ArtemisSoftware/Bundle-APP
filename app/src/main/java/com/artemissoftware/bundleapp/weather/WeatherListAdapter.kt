package com.artemissoftware.bundleapp.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WeatherListAdapter(private val list: List<ListWeather>) : RecyclerView.Adapter<WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WeatherViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(list.get(position).weather[0])
    }

    override fun getItemCount(): Int = list.size

}