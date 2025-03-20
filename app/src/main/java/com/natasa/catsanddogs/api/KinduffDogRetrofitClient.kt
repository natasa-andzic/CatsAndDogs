package com.natasa.catsanddogs.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KinduffDogRetrofitClient {

    private const val BASE_URL = "https://dog-api.kinduff.com" // Your base URL

    // Create a logging interceptor for debugging (optional)
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor) // Add the logging interceptor
        .build()

    // Create Retrofit instance
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())  // Gson converter to parse JSON
        .client(client)
        .build()

    // Create an instance of ApiService
    val apiService: KinduffDogService = retrofit.create(KinduffDogService::class.java)
}