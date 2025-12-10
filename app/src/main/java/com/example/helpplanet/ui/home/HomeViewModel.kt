package com.example.helpplanet.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpplanet.data.model.Desafio
import com.example.helpplanet.data.repository.DesafiosRepository
import com.example.helpplanet.util.events.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = DesafiosRepository()

    private val _state = MutableStateFlow<List<Desafio>>(emptyList())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<UiEvent>()
    val event = _event.asSharedFlow()

    fun carregar() {
        viewModelScope.launch {
            try {
                val lista = repository.listarDesafios()
                _state.value = lista
            } catch (e: Exception) {
                _event.emit(UiEvent.ShowToast("Erro ao carregar dados: ${e.message}"))
            }
        }
    }
}
