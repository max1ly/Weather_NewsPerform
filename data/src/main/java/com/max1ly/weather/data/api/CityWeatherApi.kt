package com.max1ly.weather.data.api

import com.max1ly.weather.data.api.dto.WeatherDto
import retrofit2.http.GET

interface CityWeatherApi {

    @GET("weather.json")
    suspend fun getCityWeather(): WeatherDto

}