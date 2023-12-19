package ru.evteev.volkswagen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import ru.evteev.volkswagen.databinding.ActivityCarBinding
import ru.evteev.volkswagen.fragments.HomeFragment
import ru.evteev.volkswagen.models.Car
import ru.evteev.volkswagen.viewmodel.CarDetailViewModel

class CarActivity : AppCompatActivity() {

    private lateinit var car: Car

    private lateinit var vm: CarDetailViewModel

    private lateinit var binding: ActivityCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProviders.of(this)[CarDetailViewModel::class.java]

        getCarFromIntent();


        observerCar()
    }

    private fun getCarFromIntent() {
        val intent = intent

        val carId = intent.getStringExtra(HomeFragment.CAR_ID)!!

        vm.getCar(carId.toInt());

//        carModel = intent.getStringExtra(HomeFragment.CAR_MODEL)!!
//        carThumb = intent.getStringExtra(HomeFragment.CAR_THUMB)!!
//        carDesc = intent.getStringExtra(HomeFragment.CAR_DESC)!!
    }

    private fun observerCar() {
        vm.observeCarLiveData().observe(this
        ) { car ->
            binding.collapsingToolbar.title = car.model.plus(" - ").plus(car.releaseYear);
            binding.textHistory.text = car.description
//            binding.textReleaseYear.text = getString(R.string.LABEL_CAR_DETAIL_YEAR).plus(car.releaseYear)
            binding.textVehicleType.text = getString(R.string.LABEL_CAR_DETAIL_BODYWORK).plus(car.bodywork)
            Glide.with(this)
                .load(car.imageLink)
                .into(binding.imgCarDetail)

            this.car = car;
        }
    }
}
