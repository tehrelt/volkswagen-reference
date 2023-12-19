package ru.evteev.volkswagen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import ru.evteev.volkswagen.databinding.FragmentHomeBinding
import ru.evteev.volkswagen.models.Car
import ru.evteev.volkswagen.viewmodel.HomeViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var vm: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(this)[HomeViewModel::class.java]
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

        vm.getCar(5);
        observerCar()

    }

    private fun observerCar() {
        vm.observeCarLiveData().observe(viewLifecycleOwner, object : Observer<Car> {
            override fun onChanged(value: Car) {
                binding.labelHomeTodayCarModel.text = value.model
                binding.labelHomeTodayCarDescription.text = value.description
                Glide.with(this@HomeFragment)
                    .load(value.imageLink)
                    .into(binding.imageViewHomeToday)
            }

        })
    }
}