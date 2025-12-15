package com.example.helpplanet.viewmodel


sealed class UiEvent {
    data class ShowToast(val message: String) : UiEvent()
}