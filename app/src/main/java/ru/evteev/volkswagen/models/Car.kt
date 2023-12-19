package ru.evteev.volkswagen.models

import com.google.gson.annotations.SerializedName


data class ResponseCars (

    @SerializedName("data"  ) var data  : ArrayList<Car> = arrayListOf(),
    @SerializedName("count" ) var count : Int?            = null

)

data class ResponseCar (

    @SerializedName("data" ) var data : Car? = Car()

)

data class Car (

    @SerializedName("id"           ) var id          : Int?    = null,
    @SerializedName("model"        ) var model       : String? = null,
    @SerializedName("release_year" ) var releaseYear : Int?    = null,
    @SerializedName("description"  ) var description : String? = null

)