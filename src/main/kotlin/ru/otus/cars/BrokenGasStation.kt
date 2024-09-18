package ru.otus.cars

import java.security.InvalidParameterException

class BrokenGasStation: GasStation {
    override fun fuelCar(car: Car, liters: Int) {
        when(car.tankMouth.fuelType) {
            FuelType.LPG -> {
                println("Fueling LPG car $car, forget to open tank mouth")
                try {
                    car.tankMouth.fuelTank(FuelType.LPG, liters)
                } catch (e: InvalidParameterException) {
                    println("Unable to fuel car, invalid fuel type")
                }
                car.tankMouth.close()
                println("New car status $car")
            }
            FuelType.PETROL -> {
                println("Fueling petrol car $car with LPG fuel")
                car.tankMouth.open()
                car.tankMouth.fuelTank(FuelType.LPG, liters)
                car.tankMouth.close()
                println("New car status $car")
            }
        }
    }

    override fun fuelMultipleCars(cars: List<Car>, liters: Int) {
        for (car in cars) {
            fuelCar(car, liters)
        }
    }
}