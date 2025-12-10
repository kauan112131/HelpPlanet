package com.example.helpplanet.data.remote

data class AirQualityResponse(
    val parameter: String?,
    val value: Double?,
    val unit: String?,
    val results: List<AirResult>
)

data class AirResult(
    val location: String,
    val city: String?
)
