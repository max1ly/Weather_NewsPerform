package com.max1ly.weather.domain.repository

import com.max1ly.weather.domain.Result
import com.max1ly.weather.domain.model.CityWeather

interface CityWeatherRepository {

    suspend fun getCityWeather(): Result<List<CityWeather>>

}