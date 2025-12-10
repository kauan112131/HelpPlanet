package com.example.helpplanet.util.events

sealed class UiEvent {
    data class ShowToast(val msg: String) : UiEvent()
    data class Navigate(val route: Int) : UiEvent()
}
