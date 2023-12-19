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
import ru.evteev.volkswagen.databinding.FragmentHomeBinding
import ru.evteev.volkswagen.models.Car
import ru.evteev.volkswagen.models.ResponseCar
import ru.evteev.volkswagen.retrofit.RetrofitInstance

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RetrofitInstance.api.getCar(1).enqueue(object : Callback<ResponseCar> {
            override fun onResponse(call: Call<ResponseCar>, response: Response<ResponseCar>) {
                if(response.body() == null) {
                    return;
                }

                val car: Car = response.body()!!.data;

                binding.labelHomeTodayCarModel.text = car.model
                binding.labelHomeTodayCarDescription.text = car.description


            }

            override fun onFailure(call: Call<ResponseCar>, t: Throwable) {
                Log.d("HomeFragment", t.message.toString())
            }

        })
    }
}