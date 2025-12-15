package com.example.helpplanet.data.model

data class EcoChallenge(
    val id: Int,
    val title: String,
    val description: String,
    val completed: Boolean = false
)