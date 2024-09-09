package ru.otus.cars

interface FuelStation {
    fun refuelCar(car: Car, liters: Int)
    fun refuelCar(cars: List<Car>, liters: Int)
}