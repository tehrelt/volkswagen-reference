package ru.evteev.volkswagen.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.evteev.volkswagen.models.Car
import ru.evteev.volkswagen.models.ResponseCar
import ru.evteev.volkswagen.retrofit.RetrofitInstance

class HomeViewModel : ViewModel() {
    private var carLiveData = MutableLiveData<Car>()
    fun getCar(id: Int) {
        RetrofitInstance.api.getCar(id).enqueue(object : Callback<ResponseCar> {
            override fun onResponse(call: Call<ResponseCar>, response: Response<ResponseCar>) {
                if(response.body() == null) {
                    return;
                }

                val car: Car = response.body()!!.data;
                carLiveData.value = car
            }

            override fun onFailure(call: Call<ResponseCar>, t: Throwable) {
                Log.d("HomeViewModel", t.message.toString())
            }
        })
    }

    fun observeCarLiveData() : LiveData<Car> {
        return carLiveData
    }
}