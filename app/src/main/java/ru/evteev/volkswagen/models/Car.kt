package ru.evteev.volkswagen.models

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("id")
    var id: Int,

    @SerializedName("model")
    var model: String,

    @SerializedName("release_year")
    var releaseYear: Int,

    @SerializedName("description")
    var description: String?
)
