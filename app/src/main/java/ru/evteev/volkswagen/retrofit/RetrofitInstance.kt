package ru.evteev.volkswagen.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: VolkswagenApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.131:4343")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VolkswagenApi::class.java)
    }
}