package ru.evteev.volkswagen.models


import com.google.gson.annotations.SerializedName

data class CarPreview(
    @SerializedName("id")
    val id: Int,
    @SerializedName("model")
    val model: String,
    @SerializedName("image_link")
    val imageLink: String
)

data class Car(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("model")
    val model: String,
    @SerializedName("release_year")
    val releaseYear: Int,
    @SerializedName("image_link")
    val imageLink: String,
    @SerializedName("bodywork")
    val bodywork: String
)