package com.example.helpplanet.ui.listar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpplanet.data.repository.DesafiosRepository
import kotlinx.coroutines.launch

class ListarDesafiosViewModel(
    private val repository: DesafiosRepository = DesafiosRepository()
) : ViewModel() {

    private val _state = MutableLiveData<DesafioState>()
    val state: LiveData<DesafioState> get() = _state

    fun carregarDesafios() {
        _state.value = DesafioState.Loading

        viewModelScope.launch {
            try {
                val lista = repository.listarDesafios()
                _state.value = DesafioState.Sucesso(lista)
            } catch (e: Exception) {
                _state.value = DesafioState.Erro(e.message ?: "Erro inesperado")
            }
        }
    }
}
