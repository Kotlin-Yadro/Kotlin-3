package ru.otus.cars.gas_station

import ru.otus.cars.Car

interface GasStation {
    fun refuelCar(car: Car, litres: Int): Boolean
    fun refuelCar(tasks: List<Pair<Car, Int>>)
    fun refuelCar(cars: List<Car>, litres: Int)
}