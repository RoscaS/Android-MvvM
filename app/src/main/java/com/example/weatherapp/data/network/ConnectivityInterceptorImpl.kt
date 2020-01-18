package com.example.weatherapp.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.example.weatherapp.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Make sure there is an active internet connection
 */
class ConnectivityInterceptorImpl(
        context: Context
) : ConnectivityInterceptor {

  private val appContext = context.applicationContext

  override fun intercept(chain: Interceptor.Chain): Response {
    if (!isOnline()) throw NoConnectivityException()
    return chain.proceed(chain.request())
  }

  private fun isOnline(): Boolean {
    val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
  }
}