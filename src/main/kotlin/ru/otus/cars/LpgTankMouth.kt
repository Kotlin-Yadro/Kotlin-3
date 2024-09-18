package ru.otus.cars

import java.security.InvalidParameterException

class LpgTankMouth(lpgTank: Tank) : TankMouth(FuelType.LPG, lpgTank) {
    override fun fuelTank(fuelType: FuelType, liters: Int) {
        if (!isOpened) {
            println("Unable to fuel petrol because mouth is closed")
            return
        }

        if (fuelType != this.fuelType)
            throw InvalidParameterException("This car accepts only ${this.fuelType} not $fuelType, tank exploded")

        println("Fueling LPG")
        tank.receiveFuel(liters)
    }
}