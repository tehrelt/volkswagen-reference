package ru.evteev.volkswagen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import ru.evteev.volkswagen.databinding.ActivityCarBinding
import ru.evteev.volkswagen.fragments.HomeFragment

class CarActivity : AppCompatActivity() {
    private lateinit var carId: String
    private lateinit var carModel: String
    private lateinit var carDesc: String
    private lateinit var carThumb: String
    private lateinit var binding: ActivityCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCarFromIntent();

        setupUI()
    }

    private fun setupUI() {
        Glide.with(applicationContext)
            .load(carThumb)
            .into(binding.imgCarDetail)

        binding.collapsingToolbar.title = carModel;
        binding.textHistory.text = carDesc;
    }

    private fun getCarFromIntent() {
        val intent = intent

        carId = intent.getStringExtra(HomeFragment.CAR_ID)!!
        carModel = intent.getStringExtra(HomeFragment.CAR_MODEL)!!
        carThumb = intent.getStringExtra(HomeFragment.CAR_THUMB)!!
        carDesc = intent.getStringExtra(HomeFragment.CAR_DESC)!!
    }
}
