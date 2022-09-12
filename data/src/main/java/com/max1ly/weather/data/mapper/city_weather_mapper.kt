package com.max1ly.weather.data.mapper

import com.max1ly.weather.data.api.dto.CityWeatherResponse
import com.max1ly.weather.data.api.dto.WeatherDto
import com.max1ly.weather.domain.model.CityWeather

fun WeatherDto.toDomain() = data.map { it.toDomain() }

fun CityWeatherResponse.toDomain() = CityWeather(
        id = venueID,
        name = name,
        weather = weatherCondition,
        temperature = weatherTemp
)