package com.example.animalslists.model

import com.example.animalslists.model.data.Animal
import com.example.animalslists.model.data.Cat
import com.example.animalslists.model.data.Dog
import io.reactivex.rxjava3.core.Single

class Repository {
    private val cats: List<Cat> = listOf(
        Cat("Маруся", "Рыжий"),
        Cat("Мурка", "Чёрный"),
        Cat("Барсик", "Серый"),
        Cat("Мурзик", "Рыжий"),
        Cat("Соня", "Серый"),
        Cat("Пушок", "Белый"),
    )
    private val dogs: List<Dog> = listOf(
        Dog("Мухтар", "10"),
        Dog("Рекс", "3"),
        Dog("Жучка", "8"),
        Dog("Боня", "5"),
        Dog("Полкан", "13"),
        Dog("Клёпа", "2"),
    )
    private val all: MutableList<Animal> = mutableListOf()
    init {
        all.addAll(cats)
        all.addAll(dogs)
    }

    fun getCatsList(): Single<List<Cat>> {
        return Single.just(cats)
    }
    fun getDogsList(): Single<List<Dog>> {
        return Single.just(dogs)
    }
    fun getAllList(): Single<List<Animal>> {
        return Single.just(all)
    }
}