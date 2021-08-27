package com.example.animalslists.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animalslists.R
import com.example.animalslists.model.Repository
import com.example.animalslists.model.data.Cat
import com.example.animalslists.viewmodel.adapters.CatAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CatViewModel : ViewModel() {

    var cats: MutableLiveData<List<Cat>> = MutableLiveData()
    var adapter = CatAdapter(R.layout.item_cat_rv, this)

    fun getCatAdapter(): CatAdapter {
        return adapter
    }

    fun setList() {
        val rep = Repository()
        rep.getCatsList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                cats.postValue(result)
            }, { error ->
                Log.d("Error", error.localizedMessage!!)
            })
    }

    fun getCat(position: Int): Cat? {
        return if (cats.value == null) null else cats.value!![position]
    }
}