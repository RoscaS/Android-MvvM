package com.resocoder.forecastmvvm.data.db.unitlocalized.current

import androidx.room.ColumnInfo


data class MetricCurrentWeatherEntry(
    @ColumnInfo(name = "tempC")
    override val temperature: Double,
    @ColumnInfo(name = "description")
    override val conditionText: List<String>,
    @ColumnInfo(name = "icons")
    override val conditionIconUrl: List<String>,
    @ColumnInfo(name = "windKph")
    override val windSpeed: Double,
    @ColumnInfo(name = "windDir")
    override val windDirection: String,
    @ColumnInfo(name = "precipMm")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslikeC")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visKm")
    override val visibilityDistance: Double
) : UnitSpecificCurrentWeatherEntry