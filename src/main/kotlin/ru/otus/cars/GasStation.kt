package ru.otus.cars

import kotlin.random.Random

object GasStation {
    fun refuel(car: Car, liters: Int) {
        try {
            car.mouth.open()
            car.mouth.receiveFuel(liters)
            car.mouth.close()
        } catch (ex: BlowException) {
            println("Unable to refuel: " + ex.message)
        }
    }

    fun refuel(cars: Collection<Car>) {
        for(car in cars) {
            refuel(car, Random.nextInt(1,40))
        }
    }
}