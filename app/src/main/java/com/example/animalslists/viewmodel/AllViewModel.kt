package com.example.animalslists.viewmodel

import android.util.Log
import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animalslists.R
import com.example.animalslists.model.Repository
import com.example.animalslists.model.data.Animal
import com.example.animalslists.viewmodel.adapters.AllAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class AllViewModel : ViewModel() {

    val all: MutableLiveData<List<Animal>> = MutableLiveData()
    var adapter = AllAdapter(R.layout.item_rv, this)

    fun getAllAdapter(): AllAdapter {
        return adapter
    }

    fun setList() {
        val rep = Repository()
        rep.getAllList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                all.postValue(result)
            }, { error ->
                Log.d("Error", error.localizedMessage!!)
            })
    }

    fun getAll(position: Int): Animal? {
        return if (all.value == null) null else all.value!![position]
    }
}