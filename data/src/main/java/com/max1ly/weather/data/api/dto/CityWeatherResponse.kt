package com.max1ly.weather.data.api.dto

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("data") val data: List<CityWeatherResponse>
)

data class CityWeatherResponse(
    @SerializedName("_venueID") val venueID: String,
    @SerializedName("_name") val name: String,
    @SerializedName("_country") val country: Country,
    @SerializedName("_weatherCondition") val weatherCondition: String,
    @SerializedName("_weatherConditionIcon") val weatherConditionIcon: String,
    @SerializedName("_weatherWind") val weatherWind: String,
    @SerializedName("_weatherHumidity") val weatherHumidity: String,
    @SerializedName("_weatherTemp") val weatherTemp: String,
    @SerializedName("_weatherFeelsLike") val weatherFeelsLike: String,
    @SerializedName("_sport") val sport: Sport,
    @SerializedName("_weatherLastUpdated") val weatherLastUpdated: Long,
)

data class Country(
    @SerializedName("_countryID") val id: String,
    @SerializedName("_name") val name: String,
)

data class Sport(
    @SerializedName("_sportID") val id: String,
    @SerializedName("_description") val name: String,
)

/*
            "_venueID": "97",
            "_name": "Adelaide River",
            "_country": {
                "_countryID": "16",
                "_name": "Australia"
            },
            "_weatherCondition": "Partly Cloudy",
            "_weatherConditionIcon": "partlycloudy",
            "_weatherWind": "Wind: ESE at 17kph",
            "_weatherHumidity": "Humidity: 65%",
            "_weatherTemp": "27",
            "_weatherFeelsLike": "34",
            "_sport": {
                "_sportID": "1",
                "_description": "Horse Racing"
            },
            "_weatherLastUpdated": 1401666605
 */