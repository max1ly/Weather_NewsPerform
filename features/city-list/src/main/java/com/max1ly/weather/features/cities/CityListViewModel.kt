package com.max1ly.weather.features.cities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max1ly.weather.domain.Result
import com.max1ly.weather.domain.model.CityWeather
import com.max1ly.weather.domain.usecase.GetCityWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class CityWeatherState {
    object Loading : CityWeatherState()
    data class Success(val weatherList: List<CityWeather>) : CityWeatherState()
    data class Error(val error: Throwable) : CityWeatherState()
}

@HiltViewModel
class CityListViewModel @Inject constructor(
    getCityWeatherUseCase: GetCityWeatherUseCase
) : ViewModel() {

    private var job: Job? = null

    val cityWeatherFlow = MutableStateFlow<CityWeatherState>(CityWeatherState.Loading)

    init {
        job = viewModelScope.launch {
            when (val result = getCityWeatherUseCase()) {
                is Result.Success -> {
                    cityWeatherFlow.emit(CityWeatherState.Success(result.data))
                }
                is Result.Error -> {
                    cityWeatherFlow.emit(CityWeatherState.Error(result.error))
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}