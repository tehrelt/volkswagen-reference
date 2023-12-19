package ru.evteev.volkswagen.models


import com.google.gson.annotations.SerializedName

data class ResponseCars(
    @SerializedName("count")
    val count: Int,
    @SerializedName("data")
    val `data`: ArrayList<CarPreview>
)