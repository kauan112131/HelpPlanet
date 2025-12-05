package com.example.helpplanet.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpplanet.data.remote.RetrofitClient
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    fun carregarDados() {
        viewModelScope.launch {
            try {
                val resposta = RetrofitClient.api.getAirQuality()
                println("Dados recebidos: $resposta")
            } catch (e: Exception) {
                println("Erro: ${e.message}")
            }
        }
    }
}
