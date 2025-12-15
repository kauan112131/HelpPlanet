package com.example.helpplanet.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpplanet.data.repository.WeatherRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class WeatherViewModel(
    private val repository: WeatherRepository = WeatherRepository()
) : ViewModel() {


    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState: StateFlow<WeatherUiState> = _uiState


    private val _eventChannel = Channel<UiEvent>()
    val events = _eventChannel.receiveAsFlow()


    fun loadWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading
            try {
                val response = repository.fetchCurrentWeather(latitude, longitude)
                _uiState.value = WeatherUiState.Success(response)
            } catch (e: Exception) {
                _uiState.value = WeatherUiState.Error("Erro ao carregar dados")
                _eventChannel.send(UiEvent.ShowToast("Falha na conexão"))
            }
        }
    }
}