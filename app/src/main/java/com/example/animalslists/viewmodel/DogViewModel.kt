package com.example.animalslists.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animalslists.R
import com.example.animalslists.model.Repository
import com.example.animalslists.model.data.Dog
import com.example.animalslists.viewmodel.adapters.DogAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class DogViewModel : ViewModel() {

    var dogs: MutableLiveData<List<Dog>> = MutableLiveData()
    var adapter = DogAdapter(R.layout.item_dog_rv, this)

    fun getDogAdapter(): DogAdapter {
        return adapter
    }

    fun setList() {
        val rep = Repository()
        rep.getDogsList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                dogs.postValue(result)
            }, { error ->
                Log.d("Error", error.localizedMessage!!)
            })
    }

    fun getDog(position: Int): Dog? {
        return if (dogs.value == null) null else dogs.value!![position]
    }
}