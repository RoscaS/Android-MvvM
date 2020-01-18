package com.example.weatherapp.data.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    @SerializedName("temp_c")
    val tempC: Float,
    @SerializedName("is_day")
    val isDay: String,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windKph: Float,
    @SerializedName("precip")
    val precipMm: Float,
    @SerializedName("feelslike")
    val feelslikeC: Float,
    @SerializedName("visibility")
    val visKm: Float,
    @SerializedName("weather_icons")
    val icons: List<String>,
    @SerializedName("weather_description")
    val description: List<String>
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}