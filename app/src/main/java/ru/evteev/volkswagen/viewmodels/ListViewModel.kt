package ru.evteev.volkswagen.viewmodels

import androidx.lifecycle.MutableLiveData
import ru.evteev.volkswagen.api.Event
import ru.evteev.volkswagen.models.Car

class ListViewModel : BaseViewModel() {

    val simpleLiveData = MutableLiveData<Event<Car>>()

    fun getUsers() {
        requestWithLiveData(simpleLiveData) {
            api.getCars()
        }
    }
}