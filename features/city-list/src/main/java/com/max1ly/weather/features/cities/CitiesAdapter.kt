package com.max1ly.weather.features.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max1ly.weather.domain.model.City
import com.max1ly.weather.features.cities.databinding.ItemCityWeatherBinding

class CitiesAdapter : ListAdapter<City, CitiesAdapter.CityViewHolder>(CITY_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCityWeatherBinding.inflate(inflater, parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CityViewHolder(
        private val binding: ItemCityWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: City) {
            with(binding) {
                cityName.text = city.name
                val unknown = binding.root.resources.getString(R.string.unknown)
                cityWeather.text = city.weather ?: unknown
                cityTemperature.text = city.temperature?.let {
                    binding.root.resources.getString(R.string.temperature, it)
                } ?: unknown
            }
        }
    }

    companion object {
        private val CITY_DIFF_CALLBACK = object : DiffUtil.ItemCallback<City>() {
            override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
                return oldItem == newItem
            }
        }
    }

}
