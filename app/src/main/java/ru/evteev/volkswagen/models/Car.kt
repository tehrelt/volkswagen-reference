package ru.evteev.volkswagen.models


import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("model")
    val model: String,
    @SerializedName("release_year")
    val releaseYear: Int
)