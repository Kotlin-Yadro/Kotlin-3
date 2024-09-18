package ru.otus.cars

import java.security.InvalidParameterException

class PetrolTankMouth(petrolTank: Tank) : TankMouth(FuelType.PETROL, petrolTank) {
    override fun fuelTank(fuelType: FuelType, liters: Int) {
        if (!isOpened) {
            println("Unable to fuel petrol because mouth is closed")
            return
        }

        if (fuelType != this.fuelType)
            throw InvalidParameterException("This car accepts only ${this.fuelType} not $fuelType, tank exploded")

        println("Fueling petrol")
        tank.receiveFuel(liters)
    }
}