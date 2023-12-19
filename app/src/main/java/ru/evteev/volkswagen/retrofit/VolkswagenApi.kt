package ru.evteev.volkswagen.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.evteev.volkswagen.models.ResponseCar

interface VolkswagenApi {
    @GET("cars/{id}")
    fun getCar(@Path("id") id: Int): Call<ResponseCar>
}