package com.example.helpplanet.data.remote
import DesafioResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getDesafios(): Response<DesafioResponse>
}
