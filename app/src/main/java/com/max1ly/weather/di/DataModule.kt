package com.max1ly.weather.di

import com.max1ly.weather.data.api.CityWeatherApi
import com.max1ly.weather.data.repository.cityweather.CityWeatherRepositoryImpl
import com.max1ly.weather.domain.repository.CityWeatherRepository
import com.max1ly.weather.domain.usecase.GetCityWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherApi: CityWeatherApi): CityWeatherRepository {
        return CityWeatherRepositoryImpl(weatherApi)
    }

    @Provides
    fun provideGetCityWeatherUseCase(repository: CityWeatherRepository): GetCityWeatherUseCase {
        return GetCityWeatherUseCase(repository)
    }
}