package com.example.weatherapp.data.network

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
  val downloadCurrentWeather: LiveData<CurrentWeatherResponse>

  suspend fun fetchCurrentWeather(location: String )
}