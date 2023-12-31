package ru.evteev.volkswagen.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import ru.evteev.volkswagen.CarActivity
import ru.evteev.volkswagen.adapters.CarsListAdapter
import ru.evteev.volkswagen.databinding.FragmentHomeBinding
import ru.evteev.volkswagen.decorators.GridSpacingItemDecorator
import ru.evteev.volkswagen.models.Car
import ru.evteev.volkswagen.models.CarPreview
import ru.evteev.volkswagen.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var vm: HomeViewModel

    private lateinit var todaysCar: Car
    private lateinit var carsAdapter: CarsListAdapter

    companion object {
        const val CAR_ID = "ru.evteev.volkswagen.fragments.carId"
        const val CAR_MODEL = "ru.evteev.volkswagen.fragments.carModel"
        const val CAR_THUMB = "ru.evteev.volkswagen.fragments.carThumb"
        const val CAR_DESC = "ru.evteev.volkswagen.fragments.carDescription"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(this)[HomeViewModel::class.java]

        carsAdapter = CarsListAdapter()
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

        prepareCarsListRecyclerView()

        vm.getCar(1);
        observerCar()
        onTodayCarClick();

        vm.getCars();
        observerCars();

        onCarClick();

    }

    private fun onCarClick() {
        carsAdapter.onItemClick = {car ->
            val intent = Intent(activity, CarActivity::class.java)
            intent.putExtra(CAR_ID, car.id.toString())
            intent.putExtra(CAR_MODEL, car.model)
            intent.putExtra(CAR_THUMB, car.imageLink);
            startActivity(intent);
        }
    }

    private fun prepareCarsListRecyclerView() {
        binding.recViewHomeOthers.apply {
            layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
            layoutManager.apply {
                addItemDecoration(GridSpacingItemDecorator(10));
            }
//            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
            adapter = carsAdapter

        }
    }

    private fun observerCars() {
        vm.observeCarsLiveData().observe(viewLifecycleOwner) { carList ->
            carsAdapter.setCars(carsList = carList as ArrayList<CarPreview>)
        }
    }

    private fun onTodayCarClick() {
        binding.cardTodayCar.setOnClickListener {
            val intent = Intent(activity, CarActivity::class.java)
            intent.putExtra(CAR_ID, todaysCar.id.toString())
            intent.putExtra(CAR_MODEL, todaysCar.model)
            intent.putExtra(CAR_THUMB, todaysCar.imageLink);
            intent.putExtra(CAR_DESC, todaysCar.description);
            startActivity(intent);
        }
    }

    private fun observerCar() {
        vm.observeCarLiveData().observe(viewLifecycleOwner
        ) { car ->
            binding.textTodayCarModel.text = car.model
            Glide.with(this@HomeFragment)
                .load(car.imageLink)
                .into(binding.imgTodayCar)

            this.todaysCar = car;
        }
    }
}