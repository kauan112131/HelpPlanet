package com.example.helpplanet.data.remote

import retrofit2.http.GET


interface ApiService {

    @GET("air_quality")
    suspend fun getAirQuality(): List<QualidadeArResponse>
}
