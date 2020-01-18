package com.example.weatherapp.data.network

import com.example.weatherapp.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "f5cdb91dfbfa8cabbabefc0dcde7451b"
const val BASE_URL = "http://api.weatherstack.com/"
// http://api.weatherstack.com/current?access_key=f5cdb91dfbfa8cabbabefc0dcde7451b&query=New%20York


interface WeatherstackApiService {

  @GET("current")
  fun getCurrentWeather(
          @Query("query") location: String
  ): Deferred<CurrentWeatherResponse>

  companion object {
    operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
    ): WeatherstackApiService {
      // operator kw allows for shorthand invocation: Class() instead of Class.invoke()
      val requestInterceptor = Interceptor { chain ->

        val url = chain.request()
                .url()
                .newBuilder()
                .removeAllQueryParameters("query")
                .addQueryParameter("access_key",
                                   API_KEY
                )
                .addQueryParameter("query", chain.request().url().queryParameter("query"))
                .build()

        val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

        return@Interceptor chain.proceed(request)
      }

      val okHttpClient = OkHttpClient.Builder()
              .addInterceptor(requestInterceptor)
              .addInterceptor(connectivityInterceptor)
              .build()

      return Retrofit.Builder()
              .client(okHttpClient)
              .baseUrl(BASE_URL)
              .addCallAdapterFactory(CoroutineCallAdapterFactory())
              .addConverterFactory(GsonConverterFactory.create())
              .build()
              .create(WeatherstackApiService::class.java)
    }
  }
}