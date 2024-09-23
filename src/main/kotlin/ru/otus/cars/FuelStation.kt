package ru.otus.cars

import kotlin.random.Random

object FuelStation {
    private fun refuel(car: Car, liters: Int) {
        try {
            car.tankMouth.open()
            car.tankMouth.receiveFuel(liters)
            car.tankMouth.close()
        } catch (exception: AppError.BangException) {
            println("Недоступна заправка: Взрыв")
        }
    }

    fun refuelForCars(cars: Collection<Car>) {
        for(car in cars) {
            refuel(car, Random.nextInt(1,40))
        }
    }
}