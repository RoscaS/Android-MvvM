package com.resocoder.forecastmvvm.data.db.unitlocalized.current


interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val conditionText: List<String>
    val conditionIconUrl: List<String>
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}