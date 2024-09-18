package ru.otus.cars

interface GasStation {
    fun fuelCar(car: Car, liters: Int)
    fun fuelMultipleCars(cars: List<Car>, liters: Int)
}