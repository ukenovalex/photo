package ru.ukenov.foodo.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl("http://localhost:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        val mainAPI: MainAPI by lazy {
            retrofit.create(MainAPI::class.java)
        }
    }
}