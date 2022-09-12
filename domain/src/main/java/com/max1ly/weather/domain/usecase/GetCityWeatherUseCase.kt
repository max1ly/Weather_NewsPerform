package com.max1ly.weather.domain.usecase

import com.max1ly.weather.domain.repository.CityWeatherRepository

class GetCityWeatherUseCase(
    private val weatherRepository: CityWeatherRepository
) {
    suspend operator fun invoke() = weatherRepository.getCityWeather()
}