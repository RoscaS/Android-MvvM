package com.example.weatherapp.data.db.entity

import com.google.gson.annotations.SerializedName

data class WeatherLocation(
        val country: String,
        val lat: Float,
        val lon: Float,
        val localtime: String,
        @SerializedName("timezone_id")
        val tzId: String,
        @SerializedName("localtime_epoch")
        val localtimeEpoch: Long
)