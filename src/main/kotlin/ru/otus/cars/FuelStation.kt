package ru.otus.cars

interface FuelStation {
    fun fillTheTankOf(car: Car)
    fun fillTheTankOf(cars: Collection<Car>) {
        cars.forEach { fillTheTankOf(it) }
    }

    fun fillTheTankOf(vararg cars: Car) {
        cars.forEach { fillTheTankOf(it) }
    }
}