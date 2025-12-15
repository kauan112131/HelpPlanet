package com.example.helpplanet.data.remote


import com.example.helpplanet.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {


    @GET("forecast")
    suspend fun getCurrentWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current_weather") currentWeather: Boolean = true
    ): WeatherResponse
}