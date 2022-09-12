package com.max1ly.weather.data.repository.cityweather

import com.max1ly.weather.data.api.CityWeatherApi
import com.max1ly.weather.data.mapper.toDomain
import com.max1ly.weather.domain.Result
import com.max1ly.weather.domain.model.CityWeather
import com.max1ly.weather.domain.repository.CityWeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CityWeatherRepositoryImpl(
    private val cityWeatherApi: CityWeatherApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : CityWeatherRepository {

    override suspend fun getCityWeather(): Result<List<CityWeather>> = withContext(dispatcher) {
        return@withContext try {
            val weatherDto = cityWeatherApi.getCityWeather()
            val cityWeather = weatherDto.data.map { it.toDomain() }
            Result.Success(cityWeather)
        } catch (error: Exception) {
            Result.Error(error)
        }
    }
}