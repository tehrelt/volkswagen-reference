package ru.evteev.volkswagen.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.evteev.volkswagen.models.ResponseCar
import ru.evteev.volkswagen.models.ResponseCars

interface VolkswagenApi {
    @GET("cars/{id}")
    fun getCar(@Path("id") id: Int): Call<ResponseCar>
    @GET("cars/")
    fun getCars(): Call<ResponseCars>
}