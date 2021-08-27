package com.example.animalslists.model.data

data class Cat(
    override var name: String, //Маруся
    val color: String, //Рыжий
    override var type: String = "Кошка", //Кошка
) : Animal()
