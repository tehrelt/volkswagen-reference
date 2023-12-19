package ru.evteev.volkswagen.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.evteev.volkswagen.R
import ru.evteev.volkswagen.models.Car
import ru.evteev.volkswagen.models.ResponseCar
import ru.evteev.volkswagen.retrofit.RetrofitInstance

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        RetrofitInstance.api.getCar(1).enqueue(object : Callback<ResponseCar>{
            override fun onResponse(call: Call<ResponseCar>, response: Response<ResponseCar>) {
                if(response.body() == null) {
                    return;
                }

                val car: Car = response.body()!!.data;
                Log.d("TEST", "car: ${car.id} ${car.model} ${car.releaseYear}");
            }

            override fun onFailure(call: Call<ResponseCar>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}