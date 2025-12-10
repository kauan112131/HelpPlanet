package com.example.helpplanet.data.repository

import com.example.helpplanet.data.model.Desafio
import com.example.helpplanet.data.remote.RetrofitClient

class DesafiosRepository {

    private val api = RetrofitClient.api

    suspend fun listarDesafios(): List<Desafio> {
        return try {
            val response = api.getDesafios() // Response<DesafioResponse>

            if (response.isSuccessful) {
                // Extrai lista do response.body()
                response.body()?.posts ?: emptyList()
            } else {
                emptyList()
            }

        } catch (e: Exception) {
            emptyList()
        }
    }
}
