package com.example.weatherapp.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.weatherapp.R
import com.example.weatherapp.data.network.ConnectivityInterceptorImpl
import com.example.weatherapp.data.network.WeatherNetworkDataSourceImpl
import com.example.weatherapp.data.network.WeatherstackApiService
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

  companion object {
    fun newInstance() = CurrentWeatherFragment()
  }

  private lateinit var viewModel: CurrentWeatherViewModel

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.current_weather_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)

    val apiService = WeatherstackApiService(ConnectivityInterceptorImpl(this.context!!))
    val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

    weatherNetworkDataSource.downloadCurrentWeather.observe(this, Observer {
      textView.text = it.toString()
    })

    GlobalScope.launch(Dispatchers.Main) {
      weatherNetworkDataSource.fetchCurrentWeather("London")
    }
  }

}
