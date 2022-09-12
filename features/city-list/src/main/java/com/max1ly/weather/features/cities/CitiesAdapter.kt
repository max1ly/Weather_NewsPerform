package com.max1ly.weather.features.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max1ly.weather.domain.model.CityWeather
import com.max1ly.weather.features.cities.databinding.ItemCityWeatherBinding

class CitiesAdapter : ListAdapter<CityWeather, CitiesAdapter.CityViewHolder>(CITY_DIFF_CALLBACK) {

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
        fun bind(cityWeather: CityWeather) {
            with(binding) {
                cityName.text = cityWeather.name
                val unknown = binding.root.resources.getString(R.string.unknown)
                this.cityWeather.text = cityWeather.weather ?: unknown
                cityTemperature.text = cityWeather.temperature?.let {
                    binding.root.resources.getString(R.string.temperature, it)
                } ?: unknown
            }
        }
    }

    companion object {
        private val CITY_DIFF_CALLBACK = object : DiffUtil.ItemCallback<CityWeather>() {
            override fun areItemsTheSame(oldItem: CityWeather, newItem: CityWeather): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: CityWeather, newItem: CityWeather): Boolean {
                return oldItem == newItem
            }
        }
    }

}
