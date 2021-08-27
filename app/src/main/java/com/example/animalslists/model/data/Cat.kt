package com.example.animalslists.model.data

import androidx.databinding.BaseObservable
import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("name")
    override var name: String, //Маруся
    @SerializedName("color")
    val color: String, //Рыжий
    @SerializedName("type")
    override var type: String = "Кошка", //Кошка
) : Animal()
