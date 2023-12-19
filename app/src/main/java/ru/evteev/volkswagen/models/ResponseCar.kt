package ru.evteev.volkswagen.models


import com.google.gson.annotations.SerializedName

data class ResponseCar (
    @SerializedName("data")
    val `data`: Car
)