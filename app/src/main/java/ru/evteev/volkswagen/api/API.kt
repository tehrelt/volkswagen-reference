package ru.evteev.volkswagen.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.evteev.volkswagen.models.Car

interface Api {

    @GET("/cars/")
    suspend fun getCars(): ResponseWrapper<Car>

    @GET("/cars/{id}")
    suspend fun getCar(@Path("id") id: Int): ResponseWrapper<Car>
}