package com.example.helpplanet.data.repository


import com.example.helpplanet.data.remote.RetrofitInstance


class WeatherRepository {


    suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double
    ) = RetrofitInstance.api.getCurrentWeather(latitude, longitude)
}