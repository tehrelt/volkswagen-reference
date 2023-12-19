package ru.evteev.volkswagen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.evteev.volkswagen.databinding.ListCarsBinding
import ru.evteev.volkswagen.models.Car

class CarsListAdapter(): RecyclerView.Adapter<CarsListAdapter.CarItemViewHolder>() {

    private var carsList = ArrayList<Car>()

    fun setCars(carsList: ArrayList<Car>) {
        this.carsList = carsList;
        notifyDataSetChanged()
    }

    class CarItemViewHolder(val binding: ListCarsBinding): RecyclerView.ViewHolder(binding.root);

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemViewHolder {
        return CarItemViewHolder(ListCarsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    override fun onBindViewHolder(holder: CarItemViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(carsList[position].imageLink)
            .into(holder.binding.thumb)
        holder.binding.title.text = carsList[position].model
    }

}