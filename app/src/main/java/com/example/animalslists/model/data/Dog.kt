package com.example.animalslists.model.data

import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("name")
    override var name: String, //Мухтар
    @SerializedName("age")
    val age: String, //8
    @SerializedName("type")
    override var type: String = "Собака", //Собака
) : Animal()
