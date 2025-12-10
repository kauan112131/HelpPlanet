package com.example.helpplanet.ui.listar

import com.example.helpplanet.data.model.Desafio

sealed class DesafioState {
    object Loading : DesafioState()
    data class Sucesso(val lista: List<Desafio>) : DesafioState()
    data class Erro(val mensagem: String) : DesafioState()
}
