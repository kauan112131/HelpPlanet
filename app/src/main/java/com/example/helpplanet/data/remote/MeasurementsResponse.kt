package com.example.helpplanet.data.remote.responses

data class MeasurementsResponse(
    val meta: Meta?,
    val results: List<Measurement>?
)

data class Meta(
    val found: Int?,
    val license: String?,
    val name: String?,
    val website: String?
)

data class Measurement(
    val location: String?,
    val parameter: String?,
    val value: Double?,
    val unit: String?,
    val date: DateInfo?
)

data class DateInfo(
    val utc: String?,
    val local: String?
)
