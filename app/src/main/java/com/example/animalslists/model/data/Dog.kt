package com.example.animalslists.model.data

data class Dog(
    override var name: String, //Мухтар
    val age: String, //8
    override var type: String = "Собака", //Собака
) : Animal()
