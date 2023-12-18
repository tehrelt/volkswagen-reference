package ru.evteev.volkswagen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.evteev.volkswagen.api.Status
import ru.evteev.volkswagen.models.Car
import ru.evteev.volkswagen.viewmodels.ListViewModel
import ru.evteev.volkwagen.R

class MainActivity : AppCompatActivity() {

    private lateinit var activityViewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityViewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        observeGetPosts()

    }

    // Наблюдаем за нашей лайвдатой
    // В зависимости от Ивента устанавливаем нужное состояние вью
    private fun observeGetPosts() {
        activityViewModel.simpleLiveData.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> viewOneLoading()
                Status.SUCCESS -> viewOneSuccess(it.data)
                Status.ERROR -> viewOneError(it.error)
            }
        })
    }


//    private fun buttonOneClickListener() {
//        btn_test_one.setOnClickListener {
//            activityViewModel.getUsers(page = 1)
//        }
//    }
//
//    // Здесь так же наблюдаем за Ивентом, используя колбек
//    private fun buttonTwoClickListener() {
//        btn_test_two.setOnClickListener {
//            activityViewModel.getUsersError(page = 2) {
//                when (it.status) {
//                    Status.LOADING -> viewTwoLoading()
//                    Status.SUCCESS -> viewTwoSuccess(it.data)
//                    Status.ERROR -> viewTwoError(it.error)
//                }
//            }
//        }
//    }

    private fun viewOneLoading() {
        // Пошла загрузка, меняем состояние вьюх
    }

    private fun viewOneSuccess(data: Car?) {
    }

    private fun viewOneError(error: Error?) {
        // Показываем ошибку
    }

    private fun viewTwoLoading() {}

    private fun viewTwoSuccess(data: Car?) {}

    private fun viewTwoError(error: Error?) {
        error?.let {
//            Toast.makeText(applicationContext, error.errorMsg, Toast.LENGTH_SHORT).show()
        }
    }
}