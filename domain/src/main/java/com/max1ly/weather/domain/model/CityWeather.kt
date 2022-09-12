package com.max1ly.weather.domain.model

data class CityWeather(
    val id: String,
    val name: String,
    val weather: String?,
    val temperature: String?,
)